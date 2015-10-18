package math_operations;

import Drawable.Drawable;
import turtle_commands.ParserCommand;

public class CosOperation implements ParserCommand {
	private double expr1;
	
	public CosOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return Math.cos(expr1);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}