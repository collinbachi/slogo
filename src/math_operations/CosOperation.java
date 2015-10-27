package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

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