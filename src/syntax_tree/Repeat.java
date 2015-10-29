package syntax_tree;

import client.ParserClient;

public class Repeat extends commandState implements returnsValue{
	
	private double arg0;
	
	public Repeat(ParserClient parserClient, returnsValue arg0, returnsCommandList arg1){
		super(parserClient);
		this.arg0 = arg0.returnValue();

		for(int i = 0; i < this.arg0; i++){
			//getCommandList().addAll(arg1.getCommandList());
			arg1.getCommandList().get(i).postToClient();
		}
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}
}
