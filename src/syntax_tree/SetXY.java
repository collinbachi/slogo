package syntax_tree;

import client.ParserClient;

public class SetXY extends commandState implements returnsValue, postCommand{
	
	private double arg0;
	private double arg1;
	private ParserClient parseClient;
	
	public SetXY(ParserClient parseClient, returnsValue arg0, returnsValue arg1){
		super(parseClient);
		this.arg0 = arg0.returnValue();
		this.arg1 = arg1.returnValue();
		this.parseClient = parseClient;
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0 + arg1;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		
		parseClient.postCommand(parserCommandFactory.getCommand("SETXY", this.arg0, this.arg1));
	}

}
