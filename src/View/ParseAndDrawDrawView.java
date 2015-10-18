package View;

import java.util.concurrent.TimeUnit;

import Client.ParserClient;
import Drawable.DrawCommand;
import Drawable.DrawRequest;
import SLOGO.SLOGOApplication;
import javafx.animation.PathTransition;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.ScaleTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class ParseAndDrawDrawView extends ConcreteView implements DrawView {

	private static final double OBJECT_HOME_X = 450;
	private static final double OBJECT_HOME_Y = 400;
	
	private ImageView myObject;
	private Boolean penUp;
	private Boolean isShowing;
	private double myOldX;
	private double myOldY;
	
	private double myDestX;
	private double myDestY;
	private double myDestHeading;
	private double mySpeed;
	
	private Boolean readyToDraw;

	private Color myPenColor;
	
	private ParserClient myClient;

	private View baseView;

	public ParseAndDrawDrawView (View view, ParserClient client) {
		super();
		myClient = client;

		baseView = view;
		baseView.addToRoot(myRoot);
		
		myObject = null;
		readyToDraw = false;
		
		setPenColor(Color.BLACK);
	}
	
	// Core functions
	
	private void paint() {
		double newX = getX();
		double newY = getY();
		
		double lineStartX = myOldX + Math.cos(Math.toRadians(myObject.getRotate()))*(myObject.getBoundsInParent().getWidth() / 2);
		double lineStartY = myOldY + Math.sin(Math.toRadians(myObject.getRotate()))*(myObject.getBoundsInParent().getHeight() / 2);
		
		double lineEndX = newX + Math.cos(Math.toRadians(myObject.getRotate()))*(myObject.getBoundsInParent().getWidth() / 2);
		double lineEndY = newY + Math.sin(Math.toRadians(myObject.getRotate()))*(myObject.getBoundsInParent().getHeight() / 2);
		
		Line line = new Line(lineStartX, lineStartY, lineEndX, lineEndY);
		myRoot.getChildren().add(line);
		myOldX = getX();
		myOldY = getY();
		
//		System.out.println(myOldY);
//		System.out.println(newY);
		
	}
	
	private void move() {
		if (myDestX != getX()) {
			double amt = toward(myDestX, getX(), mySpeed * SLOGOApplication.SECOND_DELAY, true);
			myObject.setX(amt);
		}
		
		if (myDestY != getY()) {
			double amt = toward(myDestY, getY(), mySpeed * SLOGOApplication.SECOND_DELAY, false);
			myObject.setY(amt);
		}
	}
	
	private double toward(double to, double from, double amt, Boolean isX) {
		double factor = 1;
		if (isX) {
			factor = Math.abs(Math.cos(Math.toRadians(90 - myObject.getRotate())));
		}
		else {
			factor = Math.abs(Math.sin(Math.toRadians(90 - myObject.getRotate())));
		}
		if (Math.abs(to - from) <= amt + .01) {
			return to;
		}
		if (to < from) {
			return from - factor * amt;
		}
		return from + factor * amt;
	}
	
	private void rotate() {
		if (Math.abs(myDestHeading - myObject.getRotate()) <= .01) {
			myObject.setRotate(myDestHeading);
		}
		else if (myDestHeading < myObject.getRotate()) {
			myObject.setRotate(myObject.getRotate() - mySpeed * SLOGOApplication.SECOND_DELAY);
		}
		else {
			myObject.setRotate(myObject.getRotate() + mySpeed * SLOGOApplication.SECOND_DELAY);
		}
	}

	// Override coordinates to place 0,0 at the center of the drawing board

	@Override
	protected double X(double x) {
		return x;
	}

	@Override
	protected double Y(double y) {
		return SLOGOApplication.HEIGHT - y;
	}


	// DrawView functions
	
	public void update() {
		double x = getX();
		double y = getY();
		if (Math.abs(myDestX - x) > .01 || Math.abs(myDestY - y) > .01) {
			move();
		}
		
		if (Math.abs(myDestHeading - myObject.getRotate()) > .01) {
			rotate();
		}
		
		if (!penUp && readyToDraw) {
			paint();
		}
	}
	
	public void initObject(String filename, double x, double y, double orientation) {
		Image objectImage = getImage(filename);
		myObject = initImageView(objectImage, X(x + OBJECT_HOME_X), Y(y + OBJECT_HOME_Y));
		myObject.setRotate(orientation);
		myObject.setTranslateX(0);
		myObject.setTranslateY(0);
		myObject.setX(getX());
		myObject.setY(getY());
		myRoot.getChildren().add(myObject);
		penUp = false;
		isShowing = true;
		
		myDestX = getX();
		myDestY = getY();
		myDestHeading = myObject.getRotate();
}

	public void drawMove(double x, double y, double speed) {
	    
	    myOldX = getX();
	    myOldY = getY();
	    
	    myDestX = x;
	    myDestY = y;
	    mySpeed = speed;
	    
		readyToDraw = true;
	}

	public void drawTurn(double degree, double speed) {
		
		myDestHeading = degree;
		mySpeed = speed;

	}

	public void drawPen(Boolean state) {
		penUp = state;
	}

	public void drawShowing(Boolean state) {
		myObject.setVisible(state);
	}

	public void drawClear() {
		myRoot.getChildren().clear();
		myRoot.getChildren().add(myObject);
		myObject.setX(X(0));
		myObject.setY(Y(0));
		myObject.setRotate(90);
		
	}

	public double getX() {
		return myObject.getX() + myObject.getTranslateX();
	}

	public double getY() {
		return myObject.getY() + myObject.getTranslateY();
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

	public void setPenColor(Color color) {
		myPenColor = color;
	}
}