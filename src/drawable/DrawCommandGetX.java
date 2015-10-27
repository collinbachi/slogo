package drawable;

import view.DrawView;

public class DrawCommandGetX implements DrawRequest {

	public DrawCommandGetX() {
	}


	public double get(DrawView view) {
		return view.getX();
	}
}