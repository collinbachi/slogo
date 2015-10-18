package math_operations;

import Drawable.Drawable;
import Parser.ParserCommand;

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
