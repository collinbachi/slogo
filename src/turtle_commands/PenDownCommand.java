package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

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
