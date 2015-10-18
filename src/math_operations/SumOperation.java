package math_operations;

import Drawable.Drawable;
import Parser.ParserCommand;

public class SumOperation implements ParserCommand {
	private double expr1;
	private double expr2;
	
	public SumOperation(double expr1, double expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public double set(Drawable obj) {
		return expr1 + expr2;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
