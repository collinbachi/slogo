package turtle_commands;

import drawable.Drawable;

public class SetXYCommand implements ParserCommand {
	private double x;
	private double y;
	
	public SetXYCommand(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		double xDistance = x - obj.getX();
		double yDistance = y - obj.getY();
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawXY(x, y);
		
		
	}

}
