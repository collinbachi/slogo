package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class ATanOperation implements ParserCommand {
	private double expr1;
	
	public ATanOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return Math.atan(expr1);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}