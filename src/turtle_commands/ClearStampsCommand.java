package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;
import SLOGO.StampSet;

public class ClearStampsCommand implements ParserCommand {

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
//		return this.StampSet.size();
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawClearStamps();

	}

}