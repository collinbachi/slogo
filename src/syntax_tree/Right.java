package syntax_tree;

public class Right extends commandState{
	
	private double arg0;

	public Right(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("RIGHT", this.arg0));
	}

}
