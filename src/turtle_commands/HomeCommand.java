package turtle_commands;

import drawable.Drawable;

public class HomeCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return Math.sqrt(Math.pow(obj.getX(), 2) + Math.pow(obj.getY(), 2));
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawXY(0, 0);
	}

}
