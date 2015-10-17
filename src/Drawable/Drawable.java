package Drawable;

import Parser.ParserCommand;

public interface Drawable {

	// The drawable object (turtle to start) implements this.
	// The client has an object of type Drawable that it passes commands from the parser to.

	// NOTE -- right now, we assume a heading of 0 points directly upwards, going clockwise up to 360.

	double setShowing(Boolean state);

	double setForward(double amt);
	
	double setBack(double amt);
	
	double setLeft(double degrees);
	
	double setRight(double degrees);
	
	double setHeading(double degrees);
	
	double setTowards(double x, double y);

	double setXY(double x, double y);

	double setPen(Boolean state);
		
	double setToHome();
	
	double setClearScreen();

	void drawShowing(Boolean state);

	void drawForward(double amt);
	
	void drawBack(double amt);
	
	void drawLeft(double degrees);
	
	void drawRight(double degrees);
	
	void drawHeading(double degrees);
	
	void drawTowards(double x, double y);
	
	void drawXY(double x, double y);

	void drawPen(Boolean state);
	
	void drawToHome();
	
	void drawClearScreen();

	double getX();

	double getY();

	double getHeading();

	Boolean getPenUp();

	Boolean getShowing();

	void addAnimationToQueue(ParserCommand cmd);

	double runCommand(ParserCommand cmd);

	void animate();
}