package boolean_operations;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class NotOperation implements ParserCommand {
	private double expr1;
	
	public NotOperation(double expr1){
		this.expr1 = expr1;
	}

	@Override
	public double set(Drawable obj) {
		return (expr1 == 0) ? 1 : 0;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
