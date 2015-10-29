package syntax_tree;

import client.ParserClient;

public class Home extends commandState implements postCommand{

	private ParserClient parserClient;

	public Home(ParserClient parserClient){
		super(parserClient);
		this.parserClient = parserClient;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parserClient.postCommand(parserCommandFactory.getCommand("HOME"));
		
	}

}
