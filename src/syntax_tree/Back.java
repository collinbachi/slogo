package syntax_tree;

import slogo.ParserCommandFactory;

public class Back extends commandState implements returnsValue{
	
	private double arg0;
	
	public Back(returnsValue arg0){
		this.arg0 = arg0.returnValue();
		appendToCommandList(parserCommandFactory.getCommand("BACK", this.arg0));
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return arg0;
	}

}
