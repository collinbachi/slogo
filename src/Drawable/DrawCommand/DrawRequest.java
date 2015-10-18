package Drawable.DrawCommand;

import View.DrawView;

public interface DrawRequest {

	// Like a drawCommand but just returns a double and doesn't actually draw

	double get(DrawView view);

}