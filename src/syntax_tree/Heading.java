package syntax_tree;

import client.ParserClient;

public class Heading extends commandState {

	public Heading(ParserClient parserClient) {
		super(parserClient);
		parserClient.postCommand(parserCommandFactory.getCommand("HEADING?"));
	}

}
