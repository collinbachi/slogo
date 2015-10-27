package syntax_tree;

public class IfElse extends commandState implements returnsValue{
	
	private returnsValue arg0;
	public IfElse(returnsValue arg0, returnsCommandList arg1, returnsCommandList arg2){
		this.arg0 = arg0;
		if(arg0.returnValue() == 1){
			getCommandList().addAll(arg1.getCommandList());
		}else{
			getCommandList().addAll(arg2.getCommandList());
		}
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0.returnValue();
	}

}
