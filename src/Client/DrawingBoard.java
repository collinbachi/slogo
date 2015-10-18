package Client;

import Drawable.DrawCommand.DrawCommand;
import Drawable.DrawCommand.DrawRequest;

public interface DrawingBoard {
	
	// The general application manager implements this, is passed into the Drawable object as type DrawingBoard
	// this is how the Drawable interacts with the manager.

	void drawCommand(DrawCommand cmd);

	double drawRequest(DrawRequest cmd);

	void handleDrawError(String error);
}