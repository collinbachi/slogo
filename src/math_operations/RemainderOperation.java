package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class RemainderOperation implements ParserCommand {
	private double expr1;
	private double expr2;
	
	public RemainderOperation(double expr1, double expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public double set(Drawable obj) {
		return expr1 % expr2;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}