package syntax_tree;

import java.util.ArrayList;
import parser.ParserCommand;
import slogo.CommandFactory;
import parser.ParserCommand;
import slogo.ParserCommandFactory;

public class commandState {
	ArrayList<ParserCommand> commandList = new ArrayList<ParserCommand>();
	ParserCommandFactory commandObjectFactory = new ParserCommandFactory(); 
	
	public commandState(){
		
	}
	
	protected ArrayList<ParserCommand> getCommandList(){
		return commandList;
	}
	
	protected void appendToCommandList(ParserCommand s){
		commandList.add(s);
	}
	

}
