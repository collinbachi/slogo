package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class BackCommand implements ParserCommand {
	private double distance;
	
	public BackCommand(double distance){
		this.distance = distance;
	}

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setForward(-distance);
		return distance;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawForward(-distance);
	}
}
