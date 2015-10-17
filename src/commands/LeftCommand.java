package commands;

import drawable.Drawable;

public class LeftCommand implements Command {
	private double degrees;
	
	public LeftCommand(double degrees){
		this.degrees = degrees;
	}

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
//		object.left(degrees);
		return degrees;
	}

}
