package syntax_tree;

public class Forward extends commandState implements returnsValue {
	
	private double arg0;

	public Forward(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("FORWARD", this.arg0));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}
}
