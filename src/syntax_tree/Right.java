package syntax_tree;

import client.ParserClient;

public class Right extends commandState implements returnsValue{
	
	private double arg0;

	public Right(ParserClient parserClient, returnsValue arg0){
		super(parserClient);
		this.arg0 = arg0.returnValue();
		appendToCommandList(parserCommandFactory.getCommand("RIGHT", this.arg0));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}

}
