package syntax_tree;

public class Showing extends commandState{
	
	public Showing(){
		appendToCommandList(commandObjectFactory.getCommand("SHOWING?"));
	}

}
