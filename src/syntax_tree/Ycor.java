package syntax_tree;

public class Ycor extends commandState {

	public Ycor() {
		appendToCommandList(parserCommandFactory.getCommand("YCOR?"));
	}

}
