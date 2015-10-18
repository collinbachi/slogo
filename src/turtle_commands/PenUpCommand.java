package turtle_commands;

import Drawable.Drawable;

public class PenUpCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		obj.setPenUp();
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawPenUp();;
	}
}
