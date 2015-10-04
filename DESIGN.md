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

##API Example Code##

After the user enters the command 'fd 50' into the text entry field, the submitCommand(String line, Turtle turtle) method from the Parser class is called, where line is the string 'fd 50' and turtle is the turtle object. The parser then adds this information to its queue, where it creates a command object MoveForward with the parameter 50. The addCommand method from the Turtle class is called, which adds the command object to the turtle's queue. The turtle then processes this command to effectively move forward and update its current state on a frame-by-frame basis.

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

##Design Considerations##

##Team Responsibilities##
