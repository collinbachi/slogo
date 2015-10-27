package syntax_tree;

public class HideTurtle extends commandState{
	
	public HideTurtle(){
		appendToCommandList(parserCommandFactory.getCommand("HIDETURTLE"));
	}

}
