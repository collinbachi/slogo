package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class StampCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
//		instance.stampSet.addStamp(obj.getX(), obj.getY(), obj.getShape());
		return obj.getShape();
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawStamp();
	}
}
