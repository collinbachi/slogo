package syntax_tree;

import client.ParserClient;

public class Ycor extends commandState implements postCommand{
	
	private ParserClient parseClient;

	public Ycor(ParserClient parseClient) {
		super(parseClient);
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parseClient.postCommand(parserCommandFactory.getCommand("YCOR?"));
		
	}

}
