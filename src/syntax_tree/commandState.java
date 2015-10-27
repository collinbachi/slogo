package syntax_tree;
import java.util.ArrayList;

import Parser.ParserCommand;
import SLOGO.CommandFactory;

public class commandState{
	ArrayList<ParserCommand> commandList = new ArrayList<ParserCommand>();
	CommandFactory commandObjectFactory = new CommandFactory(); 
	
	public commandState(){
		
	}
	
	protected ArrayList<ParserCommand> getCommandList(){
		return commandList;
	}
	
	protected void appendToCommandList(ParserCommand s){
		commandList.add(s);
	}
	

}
