package syntax_tree;

import java.util.ArrayList;

import client.ParserClient;
import parser.ParserCommand;
import slogo.ParserCommandFactory;
import parser.ParserCommand;
import slogo.ParserCommandFactory;

public class commandState{
	ArrayList<postCommand> commandList = new ArrayList<postCommand>();
	ParserCommandFactory parserCommandFactory = new ParserCommandFactory(); 
	ParserClient parserClient;
	
	public commandState(ParserClient parserClient){
		this.parserClient = parserClient;
		
	}
	
	protected ArrayList<postCommand> getCommandList(){
		return commandList;
	}
	
	protected void appendToCommandList(postCommand s){
		commandList.add(s);
	}
	

}
