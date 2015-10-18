package syntax_tree;

public class Xcor extends commandState{
	
	public Xcor(){
		appendToCommandList(commandObjectFactory.getCommand("XCOR?"));
	}

}
