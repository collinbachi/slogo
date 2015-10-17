package commands;

import drawable.Drawable;

public class SetHeadingCommand implements Command {
	private double heading;
	
	public SetHeadingCommand(double heading){
		this.heading = heading;
	}
	
	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
		double currentHeading = 0; // object.getHeading();
//		object.setHeading(heading);
		return heading - currentHeading;
	}

}
