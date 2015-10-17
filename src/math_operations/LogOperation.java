package math_operations;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class LogOperation implements ParserCommand {
	private double expr1;
	
	public LogOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return Math.log(expr1);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}