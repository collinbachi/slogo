package boolean_operations;

import Drawable.Drawable;
import turtle_commands.ParserCommand;

public class GreaterOperation implements ParserCommand {
	private double expr1;
	private double expr2;
	
	public GreaterOperation(double expr1, double expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public double set(Drawable obj) {
		return (expr1 > expr2) ? 1 : 0;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}