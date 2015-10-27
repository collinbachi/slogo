package syntax_tree;

import client.ParserClient;

public class HideTurtle extends commandState{
	
	public HideTurtle(ParserClient parseClient){
		super(parseClient);
		appendToCommandList(parserCommandFactory.getCommand("HIDETURTLE"));
	}

}
