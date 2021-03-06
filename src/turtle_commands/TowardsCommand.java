package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class TowardsCommand implements ParserCommand {
	private double x;
	private double y;
	
	public TowardsCommand(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public double set(Drawable obj) {
		double currentHeading = obj.getHeading();
		obj.setTowards(x, y);		
		return obj.getHeading() - currentHeading;

	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method
		obj.drawTowards(x, y);
	}
}
