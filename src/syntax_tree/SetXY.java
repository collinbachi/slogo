package syntax_tree;

public class SetXY extends commandState implements returnsValue{
	
	private double arg0;
	private double arg1;
	
	public SetXY(returnsValue arg0, returnsValue arg1){
		this.arg0 = arg0.returnValue();
		this.arg1 = arg1.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("SETXY", this.arg0, this.arg1));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0 + arg1;
	}

}
