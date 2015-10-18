package math_operations;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class MinusOperation implements ParserCommand {
	private double expr1;
	
	public MinusOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return -expr1;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}