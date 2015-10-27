package syntax_tree;

public class PenDownQuery extends commandState{
	
	public PenDownQuery(){
		appendToCommandList(parserCommandFactory.getCommand("PENDOWN?"));
	}

}
