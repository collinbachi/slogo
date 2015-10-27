package syntax_tree;

import client.ParserClient;

public class Home extends commandState{

	public Home(ParserClient parserClient){
		super(parserClient);
		appendToCommandList(parserCommandFactory.getCommand("HOME"));
	}

}
