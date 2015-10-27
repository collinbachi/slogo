package syntax_tree;

public class PenUp extends commandState {
	
	public PenUp(){
		appendToCommandList(parserCommandFactory.getCommand("PENUP"));
	}

}
