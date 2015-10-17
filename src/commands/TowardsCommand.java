package commands;

import drawable.Drawable;

public class TowardsCommand implements Command {
	private double x;
	private double y;
	
	public TowardsCommand(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
//		double currentX = object.getX();
//		double currentY = object.getY();

//		double currentHeading = object.getHeading();

//		object.setHeading(Math.atan((y - currentY)/(x - currentX)));
		
//		return object.getHeading - currentHeading;
		return 0;
	}

}
