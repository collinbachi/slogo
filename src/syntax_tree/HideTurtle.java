package syntax_tree;

public class HideTurtle extends commandState{
	
	public HideTurtle(){
		appendToCommandList(commandObjectFactory.getCommand("HIDETURTLE"));
	}

}
