package math_operations;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class RandomOperation implements ParserCommand {
	private double max;

	
	public RandomOperation(double max){
		this.max = max;
	}

	@Override
	public double set(Drawable obj) {
		return Math.random() * max;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}