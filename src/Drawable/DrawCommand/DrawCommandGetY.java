package Drawable.DrawCommand;

import View.DrawView;

public class DrawCommandGetY implements DrawRequest {

	public DrawCommandGetY() {
	}


	public double get(DrawView view) {
		return view.getY();
	}
}