#Design#

##Introduction##

We are implementing a simple Logo interpreter by writing this program. The primary design goals include designing simple, modular components within a Model View Controller (MVC) architecture. We would like our controller to be able to interpret commands and tell the model to execute them without being aware of how the model functions. Likewise, we would like our view to take in commands without understanding the functionality behind the model or controller. 

Our model will contain the state of the turtle, as well functions for modifying the state and current variables. It is open to extensions for other objects, and extra states can be added as well. 

The View will contain a turtle object, which will implement a drawable interface. We will initialize a turtle object to implement this interface, but we could also use this on any arbitrary objects. Therefore, a command can be sent to any drawable object. It will also contain a text entry field, through which the user may input logo-syntax commands, which will be passed as a string, along with the turtle object, to the controller.

The controller will contain parsing functionality that will reference a map of function types to command objects. It will also provide validation of user input and throw errors when improper code is entered by the user.  

##Overview##

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
