package slogo;



public interface DrawView {

	// All animation actions done to the drawable object are called through this interface

	void drawMove(double x, double y, double speed);

	void drawTurn(double degree, double speed);

	void drawPen(Boolean state);

	void drawShowing(Boolean state);

	void drawClear();
	
}