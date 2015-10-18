package syntax_tree;

public class Back extends commandState{
	
	private double arg0;
	
	public Back(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("BACK", this.arg0));
	}

}
