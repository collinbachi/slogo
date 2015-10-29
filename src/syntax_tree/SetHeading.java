package syntax_tree;

import client.ParserClient;

public class SetHeading extends commandState implements returnsValue, postCommand{
	
	private double arg0;
	private ParserClient parseClient;
	
	public SetHeading(ParserClient parseClient, returnsValue arg0){
		super(parseClient);
		this.parseClient = parseClient;
		this.arg0 = arg0.returnValue();
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		parseClient.postCommand(parserCommandFactory.getCommand("SETHEADING", this.arg0));
		
	}

}
