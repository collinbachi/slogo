package math_operations;

import drawable.Drawable;
import parser.ParserCommand;

public class PiOperation implements ParserCommand{

	@Override
	public double set(Drawable obj) {
		return Math.PI;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
	

}
