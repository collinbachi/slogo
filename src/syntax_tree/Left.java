package syntax_tree;

import client.ParserClient;

public class Left extends commandState implements returnsValue, postCommand{
	
	private double arg0;
	
	public Left(ParserClient parserClient, returnsValue arg0){
		super(parserClient);
		this.arg0 = arg0.returnValue();
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parserClient.postCommand(parserCommandFactory.getCommand("LEFT", this.arg0));
	}

}
