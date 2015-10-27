package syntax_tree;

import client.ParserClient;

public class Forward extends commandState implements returnsValue {
	
	private double arg0;

	public Forward(ParserClient parserClient, returnsValue arg0){
		super(parserClient);
		this.arg0 = arg0.returnValue();
		parserClient.postCommand(parserCommandFactory.getCommand("FORWARD", this.arg0));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}
}
