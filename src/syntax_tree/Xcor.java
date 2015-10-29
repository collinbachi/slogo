package syntax_tree;

import client.ParserClient;

public class Xcor extends commandState implements postCommand{
	
	private ParserClient parseClient;
	public Xcor(ParserClient parseClient){
		super(parseClient);
		this.parseClient = parseClient;
	}
	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parseClient.postCommand(parserCommandFactory.getCommand("XCOR?"));
		
	}

}
