package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import client.DrawClient;
import client.ParserClient;
import drawable.DrawCommand;
import drawable.DrawRequest;
import javafx.scene.paint.Color;
import slogo.SLOGOApplication;

public class ParseAndDrawDrawView extends ConcreteView implements DrawView {

	protected static final double OBJECT_HOME_X = 450;
	protected static final double OBJECT_HOME_Y = 400;
	
	private Map<Integer, DrawData> myObjs;
	private int toDraw;
	
	private ParserClient myParseClient;
	private DrawClient myDrawClient;

	private View baseView;

	public ParseAndDrawDrawView (View view, ParserClient parseClient, DrawClient drawClient) {
		super();
		myParseClient = parseClient;
		myDrawClient = drawClient;

		baseView = view;
		baseView.addToRoot(myRoot);
		
		myObjs = new HashMap<>();
		
	}
	
	public ParseAndDrawDrawView() {
		myParseClient = null;
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
		List<Integer> active = new ArrayList<>();
		for (int i : myObjs.keySet()) {
			myObjs.get(i).update();
			if (myObjs.get(i).getIsDrawing()) {
				myDrawClient.drawingDone(i);
			}
			if (myObjs.get(i).getIsActive()) {
				active.add(i);
			}
		}
		
		myParseClient.setActives(active);
	}
	
	public void initObject(String filename, double x, double y, double orientation) {
		myObjs.put(toDraw, new DrawData(this, this));
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
		myObjs.get(toDraw).setPenColor(color);
	}
	
	public void setActives(List<Integer> active) {
		myParseClient.setActives(active);
	}
}