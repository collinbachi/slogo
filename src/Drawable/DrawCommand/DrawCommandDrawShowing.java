package Drawable.DrawCommand;

import View.DrawView;

public class DrawCommandDrawShowing implements DrawCommand {
	
	private final Boolean myState;

	public DrawCommandDrawShowing(Boolean state) {
		myState = state;
	}


	public void draw(DrawView view) {
		view.drawShowing(myState);
	}
}