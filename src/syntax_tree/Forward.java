package syntax_tree;

public class Forward extends commandState {
	
	private double arg0;

	public Forward(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("FORWARD", this.arg0));
	}
}
