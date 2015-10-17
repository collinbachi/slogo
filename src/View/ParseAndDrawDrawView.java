package View;

import Client.ParserClient;
import Drawable.DrawCommand;

public class ParseAndDrawDrawView extends ConcreteView implements DrawView {
	
	private ParserClient myClient;

	private View baseView;

	public ParseAndDrawDrawView (View view, ParserClient client) {
		super();
		myClient = client;

		baseView = view;
		baseView.addToRoot(myRoot);
	}


	// DrawView functions

	public void drawMove(double x, double y, double speed) {

	}

	public void drawTurn(double degree, double speed) {

	}

	public void drawPen(Boolean state) {

	}

	public void drawShowing(Boolean state) {

	}

	public void drawClear() {

	}

	public void executeCommand(DrawCommand cmd) {

	}
}