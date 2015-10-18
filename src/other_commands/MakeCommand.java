package other_commands;

import Drawable.Drawable;
import SLOGO.VariableMap;
import turtle_commands.ParserCommand;

public class MakeCommand implements ParserCommand {
	private String variable;
	private double expr;
	private VariableMap vmap;
	
	public MakeCommand(String variable, double expr, VariableMap vmap){
		this.variable = variable;
		this.expr = expr;
		this.vmap = vmap;		
	}

	@Override
	public double set(Drawable obj) {
		vmap.setVariable(variable, expr);
		return expr;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
