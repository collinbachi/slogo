package Drawable;

import Parser.ParserCommand;

public interface Drawable {

	// The drawable object (turtle to start) implements this.
	// The client has an object of type Drawable that it passes commands from the parser to.

	// NOTE -- right now, we assume a heading of 0 points directly upwards, going clockwise up to 360.

	void showObj();

	void hideObj();
	
	void setForward(double amt);
	
	void setBack(double amt);
	
	void setLeft(double degrees);
	
	void setRight(double degrees);
	
	void setHeading(double degrees);
	
	void setTowards(double x, double y);

	void setPenUp();
	
	void setPenDown();
	
	void setToHome();
	
	void setClearScreen();

	void drawForward(double amt);
	
	void drawBack(double amt);
	
	void drawLeft(double degrees);
	
	void drawRight(double degrees);
	
	void drawHeading(double degrees);
	
	void drawTowards(double x, double y);
	
	void drawXY(double x, double y);

	void drawPenUp();
	
	void drawPenDown();
	
	void drawToHome();
	
	void drawClearScreen();

	double getX();

	double getY();

	double getHeading();

	Boolean getPenUp();

	Boolean getShowing();

	void addAnimationToQueue();

	void runCommand(ParserCommand cmd);
}