package syntax_tree;

import client.ParserClient;

public class Showing extends commandState implements postCommand{
	
	private ParserClient parseClient;
	public Showing(ParserClient parseClient){
		super(parseClient);
		this.parseClient = parseClient;
	}
	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parseClient.postCommand(parserCommandFactory.getCommand("SHOWING?"));
		
	}

}
