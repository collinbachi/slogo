package slogo;


import parser.ParserCommand;
import turtle_commands.*;
import turtle_queries.*;

public class ParserCommandFactory {

	public ParserCommand getCommand(String input){
		if(input.equals("PENDOWN")){
			return new PenDownCommand();
		}
		else if(input.equals("PENUP")){
			return new PenUpCommand();
		}
		else if(input.equals("SHOWTURTLE")){
			return new ShowTurtleCommand();
		}
		else if(input.equals("HIDETURTLE")){
			return new HideTurtleCommand();
		}
		else if(input.equals("HOME")){
			return new HomeCommand();
		}
		else if(input.equals("CLEARSCREEN")){
			return new ClearScreenCommand();
		}
		else if(input.equals("XCOR?")){
			return new XCorQuery();
		}
		else if(input.equals("YCOR?")){
			return new YCorQuery();
		}
		else if(input.equals("SHOWING?")){
			return new ShowingQuery();
		}
		else if(input.equals("PENDOWN?")){
			return new PenDownQuery();
		}
		else if(input.equals("HEADING?")){
			return new HeadingQuery();
		}
		else{
			return null;
		}
	}

	public ParserCommand getCommand(String input, double arg0) {
		if (input.equals("FORWARD")) {
			return new ForwardCommand(arg0);
		} else if (input.equals("BACK")) {
			return new BackCommand(arg0);
		} else if (input.equals("LEFT")) {
			return new LeftCommand(arg0);
		} else if (input.equals("RIGHT")) {
			return new RightCommand(arg0);
		} else if (input.equals("SETHEADING")) {
			return new SetHeadingCommand(arg0);
		}else{
			return null;
		}
	}

	public ParserCommand getCommand(String input, double arg0, double arg1) {
		if (input.equals("TOWARDS")) {
			return new TowardsCommand(arg0, arg1);
		} else if(input.equals("SETXY")){
			return new SetXYCommand(arg0, arg1);
		} else {
			return null;
		}
	}

}
