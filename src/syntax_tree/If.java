package syntax_tree;

import client.ParserClient;

public class If extends commandState implements postCommand{

	returnsValue arg0;
	returnsCommandList arg1;

	public If(ParserClient parserClient, returnsValue arg0, returnsCommandList arg1){
		super(parserClient);
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		if(arg0.returnValue() == 1){
			getCommandList().addAll(arg1.getCommandList()); 
		}
	}
}
