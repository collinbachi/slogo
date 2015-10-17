package math_operations;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class SinOperation implements ParserCommand {
	private double expr1;
	
	public SinOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return Math.sin(expr1);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
