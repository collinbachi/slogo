package math_operations;

import Drawable.Drawable;
import Parser.ParserCommand;

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