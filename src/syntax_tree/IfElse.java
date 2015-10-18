package syntax_tree;

public class IfElse extends commandState{
	
	public IfElse(returnsValue arg0, returnsCommandList arg1, returnsCommandList arg2){
		if(arg0.returnValue() == 1){
			getCommandList().addAll(arg1.getCommandList());
		}else{
			getCommandList().addAll(arg2.getCommandList());
		}
	}

}
