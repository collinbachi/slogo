package syntax_tree;

public class Xcor extends commandState{
	
	public Xcor(){
		appendToCommandList(parserCommandFactory.getCommand("XCOR?"));
	}

}
