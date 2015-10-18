package syntax_tree;

public class SetHeading extends commandState{
	
	private double arg0;
	
	public SetHeading(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(commandObjectFactory.getCommand("SETHEADING", this.arg0));
	}

}
