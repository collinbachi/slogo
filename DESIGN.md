#Design#

##Introduction##

We are implementing a simple Logo interpreter by writing this program. The primary design goals include designing simple, modular components within a Model View Controller (MVC) architecture. We would like our controller to be able to interpret commands and tell the model to execute them without being aware of how the model functions. Likewise, we would like our view to take in commands without understanding the functionality behind the model or controller. 

Our model will contain the state of the turtle, as well functions for modifying the state and current variables. It is open to extensions for other objects, and extra states can be added as well. 

The View will contain a turtle object, which will implement a drawable interface. We will initialize a turtle object to implement this interface, but we could also use this on any arbitrary objects. Therefore, a command can be sent to any drawable object. It will also contain a text entry field, through which the user may input logo-syntax commands, which will be passed as a string, along with the turtle object, to the controller.

The controller will contain parsing functionality that will reference a map of function types to command objects. It will also provide validation of user input and throw errors when improper code is entered by the user.  

##Overview##

The structure of our program is relatively simple. From the very beginning, what first occurs is an instantiation of the application, which sets its screen to be the default screen. The handlers (onClick, onButton, etc) are set downwards to functions defined by the screen. The default screen is the class that handles the basic flow of the program, simulating a client. It has three panes, consisting of 1) a section listing user-defined expressions, 2) the box in which the code is written, with an evaluate button underneath, and 3) the pane in which the turtle is shown. The default screen has doFrames for each of these panes. The Library pane makes a call to get the current library of user-defined procedures, and displays them. The Parser pane simply takes in the user’s text input into a box, and when the evaluate button is hit, makes a call to the parser to parse the commands in the box. The Display pane calls a doFrame update on each object in the pane (at our current stage just the turtle, but it could be any object or number of objects). These drawable objects on their doFrame check to see if they are currently executing any commands, and if they are not, and there are commands waiting, execute one of those commands. 

The structure by which commands are transferred from the parser to the interpreter is through command objects. There is an abstract interface designating the core function of a command (the function execute(Drawable obj)). Various command classes implement this interface in different ways, ranging from penUp to showTurtle, but all each command does is tell the object it is executing upon to call some command (e.g. CMDshowTurtle has execute(Drawable obj) defined as obj.showTurtle()). Take for example the command SHOWTURTLE. The parser takes this string, figures out to call its own function (likely from a hashmap of (string, function_pointer) pairs), and calls this function, showTurtle(string). This function creates a CMDshowTurtle object, and posts it to the turtle (likely by some sort of turtle.queueCommand(Command cmd)). The parser then continues parsing, not worrying about how the turtle will actually execute this command. In the turtle’s doFrame, it later checks to see if there are any commands in its queue, and now there is the aforementioned command. It then simply calls cmd.execute(this). The command takes this and calls turtle.showTurtle(), and turtle has showTurtle defined. In this way modifying the actual state of the turtle is restricted to the turtle itself, and the other parts of the code can make requests to do so, but the actual modification is handled by the turtle itself. 

In contrast, information flowing the other way, i.e. getting state information about the turtle (or any drawable object) is very public. Because modification of state data is restricted to the turtle itself, it is completely harmless to pass references to the object all around the code, and so it is trivial for the parser to access state data such as orientation or location from the turtle. In this way the API for parser-object interaction in both directions is public, but is much more heavily restricted in terms of object modification than access. 

There is one other smaller but still notable API as well that interfaces with the parser, that of the user-defined procedure library. The procedure library object is passed into the parser upon construction, but only has two public functions – getLibrary(), which returns all of the procedure objects, and addProcedure(String s), which places a new procedure object within the library based on the original string defining the procedure. The parser calls addProcedure within its own defineProcedure class, where it also adds the function to the HashMap of (string, function_pointer) pairs denoting the structural commands that the parsers possesses (such as repeat, if, etc). On the Library pane, getLibrary() is called, and all of the already-added functions are displayed. 

##User Interface##

The windows will be split into three main sections. First, there will be the workspace, an open square space where the turtle and other graphical elements are controlled and interacted with through code. Below this, will be a text box where the user can input raw ASCII text representing SLOGO commands and procedures. Next to it will be an execute button, that will consume the contents of the text box and pass them on to the parser.

The right side of the screen will be reserved for information display. The pane displayed will be controlled by selecting from several tabs at the top of the area. Available panes will include a reference of SLOGO commands, a reference of user/author defined SLOGO procedures, and a history of the user's inputted commands. 

The user will interact with the program primarily through the keyboard and text box. They will use the mouse or ENTER key to submit from the text box, and they will use the mouse to select which informational pane is currently displayed on the right side of the screen. 


##Design Details##

The API of the back-end from the perspective of the front-end is simply a method to pass in a String of user-input code and a method used to pass Command objects to the front-end's command queue. These are the only methods needed because all possible commands are Command objects and all possible user-input must bein the form of a String. This is closed for modification and open to extension because changes in supported commands will always result in new subclasses of the Command class to be created and passed to the front-end. Furthermore, the API between the back-end and future programmer's is closed for modification and open to extension because additions in functionality will only result in minor additions being made to the back-end's data structures as well minor changes to the method in which input is parsed. This design aligns with our team's goals by simplifying each classes functionality and maximizing modularity. 

##API Example Code##

After the user enters the command 'fd 50' into the text entry field, the submitCommand(String line, Turtle turtle) method from the Parser class is called, where line is the string 'fd 50' and turtle is the turtle object. The parser then adds this information to its queue, where it creates a command object MoveForward with the parameter 50. The addCommand method from the Turtle class is called, which adds the command object to the turtle's queue. The turtle then processes this command to effectively move forward and update its current state on a frame-by-frame basis.

```java
public class Turtle(){

  public postCommand(Command command){};

}

public class Parser(){

  public submitCommand(String line, Turtle turtle){};

}


public static Main(){

  submitCommand("fd 50", turtle);
  postCommand(MoveForward(turtle, 50));

}
```
##Design Considerations##

One major issue our group discussed at length was the issue of where the state of our turtle object should be held. We first considered the turtle to belong entirely to the front end. However, we encountered complications when determining the best way to handle error handling. If the turtle and its state are contained within the front end, the back end must poll the front end for updates on the turtles position and orientation and then throw exceptions in response to this. On the other hand, if the turtle and its state are contained entirely within the back end then the front end must be continuously polling the backend for its current position/orientation state. This would, however, simplify our issue of handling exceptions. 

Another factor we considered was the two different types of exceptions to be thrown by the parser in the backend. One type of exception deals with syntax errors and the other for the user trying to access a position that is outside the bounds of the current pane. We ultimately decided to pursue an architecture that reflects the Model-View-Controller design paradigm. We now consider all objects that implement the Drawable interface to be part of the model. All state is thus contained within the model as well. Our design is now further modularized with three independent entities that have minimal knowledge of implementation details within other entities. The model is nothing more than a representation of an arbitrary drawable object whose state is contained within model and the controller is just a tool to return a queue of Command objects based on code input from the user. 

Another consideration we debated was our use of Command objects. Our current design consists of a back-end parsing class creating and sending Command objects to a Turtle object, where the turtle would then pass in a reference to itself to the Command object and the respective action would be applied to the Turtle. For example, 'fd 50' would be interpreted and a MoveForward object would be passed to the turtle and the action would then be applied to the turtle object. We debated whether or not this was considered to be within the bounds of this project becausethe actual interface between the Controller and Model is just a queue of command object. However, we determined that the actual API itself lies within the method calls called by each Command object.

Furthermore, we also discussed the possibility for future extension of our project to support user-defined variables, such as assigning the current X or Y coordinate of the turtle to an arbitrarily named variable. A functionality such as this would inherently require the parser class to have access to the coordinate state that is contained within the model. We decided to initialize our parser class with a reference to the turtle passed into its constructor such that in the event of the user assigning the current X or Y coordinate to a variable, the parser may call a public getterMethod() defined within the turtle class to retrieve this information. This is less than ideal because we would like our parser to operate entirely on its own without any references to Drawable objects. However, we concluded that this design decision would be acceptable as long as there are not any other public setter methods other than what is modifiable via adding Command objects to the turtles command queue. 

One final consideration we discussed is the implementation of animation for drawing our turtle. To animate our turtle executing commands and illustrating this via our View, we need to keep our internal data structures in sync with what is being shown on the screen. The problem is that a computer can pop off Command objects from the turtles command queue very quickly, much quicker than we would like our animation to occur on screen. To account for this, we are implementing a lock on the turtles command queue. When a command is popped off the queue, the lock is enabled. The next Command object will not be popped off the queue until this lock is released, which occurs when the animation is complete. This lock will ensure consistency between our back-end datastructures and front-end animations.

##Team Responsibilities##

Jack is handling the front-end, including the model for the turtle and the view panes.

Randy, Collin and Matt will handle the back-end, including the parser and the library.
