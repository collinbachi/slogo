package View;

import Client.ParserClient;
import Drawable.DrawCommand.DrawCommand;
import Drawable.DrawCommand.DrawRequest;
import SLOGO.SLOGOApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ParseAndDrawDrawView extends ConcreteView implements DrawView {

	private static final double OBJECT_HOME_X = 65;
	private static final double OBJECT_HOME_Y = 50;
	
	private ImageView myObject;
	
	private ParserClient myClient;

	private View baseView;

	public ParseAndDrawDrawView (View view, ParserClient client) {
		super();
		myClient = client;

		baseView = view;
		baseView.addToRoot(myRoot);
	}

	//Override coordinates to place 0,0 at the center of the drawing board

	@Override
	protected double X(double x) {
		return SLOGOApplication.W_UNIT * (OBJECT_HOME_X + x);
	}

	@Override
	protected double Y(double y) {
		return SLOGOApplication.H_UNIT *((SLOGOApplication.HEIGHT / SLOGOApplication.H_UNIT) - (OBJECT_HOME_Y + y));
	}


	// DrawView functions
	
	public void initObject(String filename, double x, double y, double orientation) {
		Image objectImage = getImage(filename);
		myObject = initImageView(objectImage, X(x), Y(y));
		myObject.setRotate(orientation);
		myRoot.getChildren().add(myObject);
	}

	public void drawMove(double x, double y, double speed) {

	}

	public void drawTurn(double degree, double speed) {

	}

	public void drawPen(Boolean state) {

	}

	public void drawShowing(Boolean state) {

	}

	public void drawClear() {

	}

	public double getX() {
		return myObject.getX();
	}

	public double getY() {
		return myObject.getY();
	}

	public double getHeading() {
		return myObject.getRotate();
	}

	public void executeCommand(DrawCommand cmd) {
		cmd.draw(this);
	}

	public double executeRequest(DrawRequest cmd) {
		return cmd.get(this);
	}
}