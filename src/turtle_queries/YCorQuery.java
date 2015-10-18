package turtle_queries;

import Drawable.Drawable;
import Parser.ParserCommand;

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
