package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class LeftCommand implements ParserCommand {
	private double degrees;
	
	public LeftCommand(double degrees){
		this.degrees = degrees;
	}

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setLeft(degrees);
		return degrees;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawLeft(degrees);
	}
}
