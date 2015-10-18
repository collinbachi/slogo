package turtle_queries;

import Drawable.Drawable;
import Parser.ParserCommand;

public class HeadingQuery implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return obj.getHeading();
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
