package SLOGO;

import Parser.ParserCommand;
import SLOGO.SLOGOScanner.Token;
import turtle_commands.BackCommand;
import turtle_commands.ForwardCommand;
import turtle_commands.LeftCommand;
import turtle_commands.RightCommand;
import turtle_commands.SetHeadingCommand;
import turtle_commands.TowardsCommand;

public class CommandFactory {
	
	public ParserCommand getCommand(String input, double arg0){
		if(input.equals("FORWARD")){
			return new ForwardCommand(arg0);
		}else{
			return null; 
		}
	}
	//public ParserCommand getCommand(Token type, double expr1, double expr2, String key, VariableMap vmap, ProcedureMap pmap){
	//	SLOGOScanner.Token newToken = SLOGOScanner.Token.AND;

	//	if(type.equals("FORWARD")){
	//		return new ForwardCommand(expr1);
	//	}
	//	else if(type.equals("BACK")){
	//		return new BackCommand(expr1);
	//	}
	//	else if(type.equals(Token.LEFT)){
	//		return new LeftCommand(expr1);
	//	}
	//	else if(type.equals(Token.RIGHT)){
	//		return new RightCommand(expr1);
	//	}
	//	else if(type.equals(Token.SETHEADING)){
	//		return new SetHeadingCommand(expr1);
	//	}
	//	else if(type.equals(Token.TOWARDS)){
	//		return new TowardsCommand(expr1, expr2);
	//	}
	//	return null;
	//}

}
