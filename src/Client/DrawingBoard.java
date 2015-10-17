package Client;

import Drawable.DrawCommand;

public interface DrawingBoard {
	
	// The general application manager implements this, is passed into the Drawable object as type DrawingBoard
	// this is how the Drawable interacts with the manager.

	void drawCommand(DrawCommand cmd);
}