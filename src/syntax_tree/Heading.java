package syntax_tree;

public class Heading extends commandState {

	public Heading() {
		appendToCommandList(parserCommandFactory.getCommand("HEADING?"));
	}

}
