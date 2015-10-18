package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

public class PenUpCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		obj.setPen(false);
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawShowing(false);
	}
}
