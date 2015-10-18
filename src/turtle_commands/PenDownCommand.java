package turtle_commands;

import Drawable.Drawable;

public class PenDownCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setPenDown();
		return 1;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawPenDown();
	}
}
