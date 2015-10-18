package syntax_tree;

public class PenDown extends commandState{
	
	public PenDown(){
		appendToCommandList(commandObjectFactory.getCommand("PENDOWN"));
	}

}
