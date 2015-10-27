package syntax_tree;

public class Home extends commandState{

	public Home(){
		appendToCommandList(parserCommandFactory.getCommand("HOME"));
	}

}
