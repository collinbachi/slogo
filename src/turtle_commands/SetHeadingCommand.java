package turtle_commands;

import Drawable.Drawable;

public class SetHeadingCommand implements ParserCommand {
	private double heading;
	
	public SetHeadingCommand(double heading){
		this.heading = heading;
	}

	@Override
	public double set(Drawable obj) {
		double currentHeading = obj.getHeading();
		obj.setHeading(heading);
		return heading - currentHeading;
	}

	@Override
	public void draw(Drawable obj) {
		obj.drawHeading(heading);
	}

}
