package commands;

import drawable.Drawable;

public class RightCommand implements Command {
	private double degrees;
	
	public RightCommand(double degrees){
		this.degrees = degrees;
	}

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
//		object.right(degrees);
		return degrees;
	}

}
