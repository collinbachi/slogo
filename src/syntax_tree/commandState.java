package syntax_tree;

import java.util.ArrayList;

import client.ParserClient;
import parser.ParserCommand;
import slogo.ParserCommandFactory;
import parser.ParserCommand;
import slogo.ParserCommandFactory;

public class commandState{
	ArrayList<ParserCommand> commandList = new ArrayList<ParserCommand>();
	ParserCommandFactory parserCommandFactory = new ParserCommandFactory(); 
	ParserClient parserClient;
	
	public commandState(ParserClient parserClient){
		this.parserClient = parserClient;
		
	}
	
	protected ArrayList<ParserCommand> getCommandList(){
		return commandList;
	}
	
	protected void appendToCommandList(ParserCommand s){
		commandList.add(s);
	}
	

}
