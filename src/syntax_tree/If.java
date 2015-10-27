package syntax_tree;

import client.ParserClient;

public class If extends commandState{

	public If(ParserClient parserClient, returnsValue arg0, returnsCommandList arg1){
		super(parserClient);
		if(arg0.returnValue() == 1){
			getCommandList().addAll(arg1.getCommandList()); 
		}
	}
}
