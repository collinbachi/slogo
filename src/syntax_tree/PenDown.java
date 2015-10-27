package syntax_tree;

public class PenDown extends commandState{
	
	public PenDown(){
		appendToCommandList(parserCommandFactory.getCommand("PENDOWN"));
	}

}
