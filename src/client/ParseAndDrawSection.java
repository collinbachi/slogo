package client;

import syntax_tree.SyntaxTree;

import view.ApplicationView;
import view.DrawView;
import view.ParseAndDrawApplicationView;
import view.ParseAndDrawDrawView;
import drawable.DrawCommand;
import drawable.DrawRequest;
import drawable.Drawable;

import java.util.List;

import parser.ParserCommand;
import slogo.SLOGOManager;
import slogo.SLOGOScanner;
import slogo.Token;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;


public class ParseAndDrawSection extends SLOGOSection implements DrawingBoard, ParserClient, DrawClient {
	private String rawInput = "";

	// Sub-applications

	private DrawableSet myDrawables;

	//private SLOGOScanner myParser; //Unsure what type this should be, may change.

	// View

	protected final ApplicationView myApplicationView; 

	private final DrawView myDrawView;
	
	private SLOGOScanner scanner;
	private SyntaxTree syntaxTree;


	public ParseAndDrawSection (SLOGOManager manager) {
		super(manager);

		// NOTE -- DrawView currently refers to the same object
		// However, the class is constructed in this way so that if the view becomes too complicated
		// And needs to be split up into different classes, the application won't need to be rewritten		
		myDrawView = new ParseAndDrawDrawView(myView, this, this);
		myApplicationView = new ParseAndDrawApplicationView(myView, this);
		syntaxTree = new SyntaxTree();
		
		//myParser = new SLOGOScanner(this); // ?
		
		myDrawables = new DrawableSet(this);
		myDrawables.makeFirst();

	}

	// ParserClient functions

	public void handleParseError (String error) {
		return;
	}

	public void parseText(String text) {
		scanner = new SLOGOScanner(text);
		
		//while(scanner.hasNext()){
		for (Token t : scanner){
			String temp = t.toString();
			if (temp=="NUMBER") temp = Integer.toString(t.getNumber());
			System.out.println(temp);
			syntaxTree.appendToInput(temp);
		}
		//List<postCommand> cmds = syntaxTree.parseTokens(this);
		syntaxTree.parseTokens(this);
		
		// Deprecated -- REMOVE THIS CALL ONCE POSTCOMMAND IS BEING CALLED
		//for (Drawable obj: myDrawables.getActiveObjs()) {
		//	obj.addAnimationsToQueue(cmds);
		//}
		
		//for (Drawable obj: myDrawables.getActiveObjs()) {
		//	obj.animate();
		//}
	}
	
	//Returns the last int in the list
	public int setActives(List<Integer> actives) {
		if (actives.size() < 1) {
			return -1;
		}
		myDrawables.setActive(actives);
		return actives.get(actives.size() - 1);
	}
	
	//Returns the last int in the active list
	public int getLastActive() {
		List<Integer> actives = myDrawables.getActiveInt();
		return actives.get(actives.size() - 1);
	}

	public double getX() {
		return myDrawables.getLastActive().getX();
	}

	public double getY() {
		return myDrawables.getLastActive().getY();
	}

	public double getHeading() {
		return myDrawables.getLastActive().getHeading();
	}

	public Boolean getPenUp() {
		return myDrawables.getLastActive().getPenUp();
	}

	public Boolean getShowing() {
		return myDrawables.getLastActive().getShowing();
	}

	public double postCommand(ParserCommand cmd) {
		double ret = 0;
		List<Drawable> iter = myDrawables.getActiveObjs();
		for (int i = 0; i < iter.size(); i++ ) {
			ret = iter.get(i).runCommand(cmd);
		}
		return ret;
	}
	
	public double postCommandToAll(ParserCommand cmd) {
		double ret = 0;
		List<Drawable> iter = myDrawables.getAll();
		for (int i = 0; i < iter.size(); i++) {
			ret = iter.get(i).runCommand(cmd);
		}
		return ret;
	}

	public void setPenColor(Color color) {
		myDrawView.setPenColor(color);
	}

	// DrawingBoard functions

	public void handleDrawError(String error) {
		return;
	}

	public void drawCommand(Drawable obj, DrawCommand cmd) {
		int i = myDrawables.getIndex(obj);
		myDrawView.executeCommand(i, cmd);
	}

	public double drawRequest(Drawable obj, DrawRequest cmd) {
		int i = myDrawables.getIndex(obj);
		return myDrawView.executeRequest(i, cmd);
	}

	// SLOGOSection functions 

	@Override
	public void handleKeyReleased(KeyCode code) {
		// TODO Auto-generated method stub
		
		if(code.toString().equals("ENTER")){
			
		}
		rawInput += code.toString();
		//System.out.println(rawInput);
		
		
	}

	@Override
	public void handleKeyPressed(KeyCode code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double elapsedTime) {
		for (Drawable obj : myDrawables.getAll()) {
			obj.animate();
		}
		myDrawView.update();
		
	}

	@Override
	public void handleMouseInput(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawingDone(int id) {
		myDrawables.get(id).setDoneDrawing();
	}

}