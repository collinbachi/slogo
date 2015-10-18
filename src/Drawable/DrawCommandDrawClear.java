package Drawable;

import View.DrawView;

public class DrawCommandDrawClear implements DrawCommand {

	public DrawCommandDrawClear() {
	}


	public void draw(DrawView view) {
		view.drawClear();
	}
}