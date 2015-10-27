package drawable;

import view.DrawView;

public class DrawCommandInitObject implements DrawCommand {
	
	private final String myFilename;
	private final double myX;
	private final double myY;
	private final double myOrientation;

	public DrawCommandInitObject(String filename, double x, double y, double orientation) {
		myFilename = filename;
		myX = x;
		myY = y;
		myOrientation = orientation;
	}


	public void draw(DrawView view) {
		view.initObject(myFilename, myX, myY, myOrientation);
	}
}