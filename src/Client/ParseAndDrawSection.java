package Client;

import Drawable.DrawCommand;
import Drawable.Drawable;
import Drawable.Turtle;
import Parser.ParserCommand;
import SLOGO.SLOGOManager;
import View.ApplicationView;
import View.DrawView;
import View.ParseAndDrawApplicationView;
import View.ParseAndDrawDrawView;
import javafx.scene.input.KeyCode;

public class ParseAndDrawSection extends SLOGOSection implements DrawingBoard, ParserClient {

	// Sub-applications

	private Drawable myDrawable;

	//private SLOGOScanner myParser; //Unsure what type this should be, may change.

	// View

	protected final ApplicationView myApplicationView; 

	private final DrawView myDrawView;


	public ParseAndDrawSection (SLOGOManager manager) {
		super(manager);
		myDrawable = new Turtle(this);
		//myParser = new SLOGOScanner(this); // ?

		// NOTE -- DrawView currently refers to the same object
		// However, the class is constructed in this way so that if the view becomes too complicated
		// And needs to be split up into different classes, the application won't need to be rewritten		
		myApplicationView = new ParseAndDrawApplicationView(myView, this);
		myDrawView = new ParseAndDrawDrawView(myView, this);

	}

	// ParserClient functions

	public void handleParseError (String error) {
		return;
	}

	public void parseText(String text) {
//		myParser.parse(text);
	}

	public double getX() {
		return myDrawable.getX();
	}

	public double getY() {
		return myDrawable.getY();
	}

	public double getHeading() {
		return myDrawable.getHeading();
	}

	public Boolean getPenUp() {
		return myDrawable.getPenUp();
	}

	public Boolean getShowing() {
		return myDrawable.getShowing();
	}

	public double postCommand(ParserCommand cmd) {
		myDrawable.runCommand(cmd);
	}

	// DrawingBoard functions

	public void drawCommand(DrawCommand cmd) {
		myDrawView.executeCommand(cmd);
	}

	// SLOGOSection functions 

	@Override
	public void handleKeyReleased(KeyCode code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleKeyPressed(KeyCode code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseInput(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}