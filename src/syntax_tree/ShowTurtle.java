package syntax_tree;

public class ShowTurtle extends commandState{
	
	public ShowTurtle(){
		appendToCommandList(commandObjectFactory.getCommand("SHOWTURTLE"));
	}

}
