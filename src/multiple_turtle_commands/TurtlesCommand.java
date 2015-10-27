package multiple_turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class TurtlesCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return obj.getID();
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
