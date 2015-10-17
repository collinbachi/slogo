package commands;

import drawable.Drawable;

public class SetXYCommand implements Command {
	private double x;
	private double y;
	
	public SetXYCommand(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
//		double xDistance = x - object.getX();
//		double yDistance = y - object.getY();
//		object.setXY(x, y);
//		return ((xDistance^2 + yDistance^2))^(.5);
		return 0;
	}

}
