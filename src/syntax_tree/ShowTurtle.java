package syntax_tree;

import client.ParserClient;

public class ShowTurtle extends commandState implements postCommand{
	
	private ParserClient parseClient;
	
	public ShowTurtle(ParserClient parseClient){
		super(parseClient);
		this.parserClient = parseClient;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parseClient.postCommand(parserCommandFactory.getCommand("SHOWTURTLE"));
	}

}
