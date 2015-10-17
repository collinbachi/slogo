package turtle_commands;

import drawable.Drawable;

public class RightCommand implements ParserCommand {
	private double degrees;
	
	public RightCommand(double degrees){
		this.degrees = degrees;
	}

	@Override
	public double set(Drawable obj) {
		obj.setRight(degrees);
		return degrees;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawRight(degrees);
	}

}
