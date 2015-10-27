package syntax_tree;

public class Showing extends commandState{
	
	public Showing(){
		appendToCommandList(parserCommandFactory.getCommand("SHOWING?"));
	}

}
