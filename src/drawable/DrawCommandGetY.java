package drawable;

import view.DrawView;

public class DrawCommandGetY implements DrawRequest {

	public DrawCommandGetY() {
	}


	public double get(DrawView view) {
		return view.getY();
	}
}