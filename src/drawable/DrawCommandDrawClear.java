package drawable;

import view.DrawView;

public class DrawCommandDrawClear implements DrawCommand {

	public DrawCommandDrawClear() {
	}


	public void draw(DrawView view) {
		view.drawClear();
	}
}