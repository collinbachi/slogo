package SLOGO;

import View.DrawView;

public interface DrawCommand {

	// The Drawable object calls commands that implement this interface, which are then passed to the client which passes them to the view.

	void draw(DrawView view);

}