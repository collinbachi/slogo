package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class TanOperation implements ParserCommand {
	private double expr1;
	
	public TanOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return Math.tan(expr1);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}