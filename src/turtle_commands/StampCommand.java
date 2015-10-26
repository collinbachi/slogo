package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

public class StampCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return obj.getShape();
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawStamp();
	}

}
