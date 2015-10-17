package Drawable.DrawCommand;

import View.DrawView;

public class DrawCommandDrawTurn implements DrawCommand {
	
	private final double myDegrees;
	private final double mySpeed;

	public DrawCommandDrawTurn(double degrees, double speed) {
		myDegrees = degrees;
		mySpeed = speed;
	}


	public void draw(DrawView view) {
		view.drawTurn(myDegrees, mySpeed);
	}
}