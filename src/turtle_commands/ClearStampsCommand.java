package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;
import slogo.StampSet;

public class ClearStampsCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
//		return instance.getStampSet.clearStamps();
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawClearStamps();
	}

}
