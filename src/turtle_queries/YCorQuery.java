package turtle_queries;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class YCorQuery implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return obj.getY();
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
