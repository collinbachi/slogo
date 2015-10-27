package boolean_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class NotEqualOperation implements ParserCommand {
	private double expr1;
	private double expr2;
	
	public NotEqualOperation(double expr1, double expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public double set(Drawable obj) {
		return (expr1 != expr2) ? 1 : 0;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}