package turtle_commands;

import Drawable.Drawable;

public class HideTurtleCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		obj.hideObj();
	}
}
