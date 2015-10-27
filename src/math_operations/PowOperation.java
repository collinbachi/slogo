package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class PowOperation implements ParserCommand {
	private double base;
	private double exp;
	
	public PowOperation(double base, double exp){
		this.base = base;
		this.exp = exp;
	}

	@Override
	public double set(Drawable obj) {
		return Math.pow(base, exp);
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
