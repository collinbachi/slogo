package commands;

import drawable.Drawable;

public class BackCommand implements Command {
	private double distance;
	
	public BackCommand(double distance){
		this.distance = distance;
	}

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
//		object.back(distance);
		return distance;
	}
}
