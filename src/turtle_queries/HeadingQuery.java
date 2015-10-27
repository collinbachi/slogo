package turtle_queries;

import drawable.Drawable;
import parser.ParserCommand;

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
