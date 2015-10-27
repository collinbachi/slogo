package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class PenUpCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		obj.setPen(false);
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawPen(false);
	}
}
