package Drawable.DrawCommand;

import View.DrawView;

public class DrawCommandGetHeading implements DrawRequest {

	public DrawCommandGetHeading() {
	}


	public double get(DrawView view) {
		return view.getHeading();
	}
}