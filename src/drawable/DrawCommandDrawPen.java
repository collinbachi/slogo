package drawable;

import view.DrawView;

public class DrawCommandDrawPen implements DrawCommand {
	
	private final Boolean myState;

	public DrawCommandDrawPen(Boolean state) {
		myState = state;
	}


	public void draw(DrawView view) {
		view.drawPen(myState);
	}
}