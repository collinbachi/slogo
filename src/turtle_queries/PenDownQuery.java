package turtle_queries;

import drawable.Drawable;
import parser.ParserCommand;

public class PenDownQuery implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		return !obj.getPenUp() ? 1: 0;
	}

	@Override
	public void draw(Drawable obj) {
		return;	
	}
	
}
