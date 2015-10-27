package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class RightCommand implements ParserCommand {
	private double degrees;
	
	public RightCommand(double degrees){
		this.degrees = degrees;
	}

	@Override
	public double set(Drawable obj) {
		obj.setLeft(-degrees);
		return degrees;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawLeft(-degrees);
	}

}
