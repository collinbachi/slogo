package syntax_tree;

public class ShowTurtle extends commandState{
	
	public ShowTurtle(){
		appendToCommandList(parserCommandFactory.getCommand("SHOWTURTLE"));
	}

}
