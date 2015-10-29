package syntax_tree;

import client.ParserClient;

public class Repeat extends commandState implements returnsValue, postCommand{
	
	private double arg0;
	private returnsCommandList arg1;
	
	public Repeat(ParserClient parserClient, returnsValue arg0, returnsCommandList arg1){
		super(parserClient);
		this.arg0 = arg0.returnValue();
		this.arg1 = arg1;
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.arg0; i++){
			for(int j = 0; j < arg1.getCommandList().size(); j++){
				arg1.getCommandList().get(j).postToClient();
			}
		}
	}
}
