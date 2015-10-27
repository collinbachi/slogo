package client;

import drawable.DrawCommand;
import drawable.DrawRequest;
import drawable.Drawable;

public interface DrawingBoard {
	
	// The general application manager implements this, is passed into the Drawable object as type DrawingBoard
	// this is how the Drawable interacts with the manager.

	void drawCommand(Drawable obj, DrawCommand cmd);

	double drawRequest(Drawable obj, DrawRequest cmd);

	void handleDrawError(String error);
}