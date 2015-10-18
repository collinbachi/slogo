package turtle_commands;
import java.util.HashSet;

import drawable.Drawable;

public class ForwardCommand implements ParserCommand {
	private double distance;
	
	public ForwardCommand(double distance){
		this.distance = distance;
	}

	@Override
	public double set(Drawable obj) {
		obj.setForward(distance);
		return distance;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawForward(distance);
	}
}
