package turtle_queries;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class ShowingQuery implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return obj.getShowing() ? 1 : 0;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
