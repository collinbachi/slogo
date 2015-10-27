package syntax_tree;

public class Repeat extends commandState implements returnsValue{
	
	private double arg0;
	
	public Repeat(returnsValue arg0, returnsCommandList arg1){
		this.arg0 = arg0.returnValue();

		for(int i = 0; i < this.arg0; i++){
			getCommandList().addAll(arg1.getCommandList());
		}

	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}
}
