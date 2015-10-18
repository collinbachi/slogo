package syntax_tree;

public class Left extends commandState{
	
	private double arg0;
	
	public Left(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("LEFT", this.arg0));
	}

}
