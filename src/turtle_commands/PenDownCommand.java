package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class PenDownCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setPen(true);
		return 1;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawPen(true);
	}
}
