package Drawable.DrawCommand;

import View.DrawView;

public class DrawCommandDrawMove implements DrawCommand {
	
	private final double myX;
	private final double myY;
	private final double mySpeed;

	public DrawCommandDrawMove(double x, double y, double speed) {
		myX = x;
		myY = y;
		mySpeed = speed;
	}


	public void draw(DrawView view) {
		view.drawMove(myX, myY, mySpeed);
	}
}