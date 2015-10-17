package turtle_commands;

import drawable.Drawable;

public class ShowTurtleCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return 1;
	}

	@Override
	public void draw(Drawable obj) {
		obj.showObj();
	}
}
