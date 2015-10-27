package drawable;

import java.util.ArrayList;
import java.util.List;

import parser.ParserCommand;

public interface Drawable {

	// The drawable object (turtle to start) implements this.
	// The client has an object of type Drawable that it passes commands from the parser to.

	// NOTE -- right now, we assume a heading of 0 points directly upwards, going clockwise up to 360.

	double setShowing(Boolean state);

	double setForward(double amt);
	
	double setLeft(double degrees);
	
	double setHeading(double degrees);
	
	double setTowards(double x, double y);

	double setXY(double x, double y);

	double setPen(Boolean state);
		
	double setToHome();
	
	double setClearScreen();
	
	double setBackground(double index);
	
	double setPenColor(double index);
	
	double setPenSize(double pixels);
	
	double setShape(double index);
	
	double setPalette(double index, double r, double g, double b);

	void drawShowing(Boolean state);

	void drawForward(double amt);
	
	void drawLeft(double degrees);
	
	void drawHeading(double degrees);
	
	void drawTowards(double x, double y);
	
	void drawXY(double x, double y);

	void drawPen(Boolean state);
	
	void drawToHome();
	
	void drawClearScreen();
	
	void drawBackground(double index);
	
	void drawStamp();
	
	void drawClearStamps();

	double getX();

	double getY();

	double getHeading();
	
	double getPenColor();
	
	double getShape();
	
	double getID();

	Boolean getPenUp();

	Boolean getShowing();

	void addAnimationToQueue(ParserCommand cmd);
	
	void addAnimationsToQueue(List<ParserCommand> cmds);

	double runCommand(ParserCommand cmd);

	void animate();
	
	void draw();
}