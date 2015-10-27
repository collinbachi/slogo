package syntax_tree;

public class Left extends commandState implements returnsValue{
	
	private double arg0;
	
	public Left(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("LEFT", this.arg0));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}

}
