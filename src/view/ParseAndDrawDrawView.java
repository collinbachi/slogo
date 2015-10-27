package view;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import client.ParserClient;
import drawable.DrawCommand;
import drawable.DrawRequest;
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
import slogo.SLOGOApplication;

public class ParseAndDrawDrawView extends ConcreteView implements DrawView {

	protected static final double OBJECT_HOME_X = 450;
	protected static final double OBJECT_HOME_Y = 400;
	
	private Map<Integer, DrawData> myObjs;
	private int toDraw;

	private Color myPenColor;
	
	private ParserClient myClient;

	private View baseView;

	public ParseAndDrawDrawView (View view, ParserClient client) {
		super();
		myClient = client;

		baseView = view;
		baseView.addToRoot(myRoot);
		
		myObjs = new HashMap<>();
		
		setPenColor(Color.BLACK);
	}
	
	public ParseAndDrawDrawView() {
		myClient = null;
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
		for (DrawData obj: myObjs.values()) {
			obj.update();
		}
	}
	
	public void initObject(String filename, double x, double y, double orientation) {
		myObjs.put(toDraw, new DrawData(this));
		myObjs.get(toDraw).initObject(filename, x, y, orientation);
	}

	public void drawMove(double x, double y, double speed) {
		myObjs.get(toDraw).drawMove(x, y, speed);
	}

	public void drawTurn(double degree, double speed) {
		myObjs.get(toDraw).drawTurn(degree, speed);
	}

	public void drawPen(Boolean state) {
		myObjs.get(toDraw).drawPen(state);
	}

	public void drawShowing(Boolean state) {
		myObjs.get(toDraw).drawShowing(state);
	}

	public void drawClear() {
		myObjs.get(toDraw).drawClear();
	}

	public double getX() {
		return myObjs.get(toDraw).getX();
	}

	public double getY() {
		return myObjs.get(toDraw).getY();
	}

	public double getHeading() {
		return myObjs.get(toDraw).getHeading();
	}

	public void executeCommand(int i, DrawCommand cmd) {
		toDraw = i;
		cmd.draw(this);
	}

	public double executeRequest(int i, DrawRequest cmd) {
		toDraw = i;
		return cmd.get(this);
	}

	public void setPenColor(Color color) {
		myPenColor = color;
	}
}