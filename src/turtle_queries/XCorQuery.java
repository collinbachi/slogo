package turtle_queries;

import drawable.Drawable;
import turtle_commands.ParserCommand;

public class XCorQuery implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		return obj.getX();
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
