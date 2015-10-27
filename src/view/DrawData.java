package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import slogo.SLOGOApplication;

public class DrawData extends ParseAndDrawDrawView {

	
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
	
	private Boolean isDrawing;
	private Boolean isActive;

	private View myView;
	
	private DrawView myDrawView;
	
	public DrawData (View view, DrawView drawView) {
		myView = view;
		myDrawView = drawView;
		myView.addToRoot(myRoot);
		
		penUp = false;
		isShowing = true;
		readyToDraw = false;
		isDrawing = false;
		isActive = false;
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
			
//			System.out.println(myOldY);
//			System.out.println(newY);
			
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
	
	public void update() {
		double x = getX();
		double y = getY();
		isDrawing = false;
		if (Math.abs(myDestX - x) > .01 || Math.abs(myDestY - y) > .01) {
			move();
			isDrawing = true;
		}
		
		if (Math.abs(myDestHeading - myObject.getRotate()) > .01) {
			rotate();
			isDrawing = true;
		}
		
		if (!penUp && readyToDraw) {
			paint();
			isDrawing = true;
		}
		
		if (isActive) {
			 int depth = 70; //Setting the uniform variable for the glow width and height
			 
			DropShadow borderGlow= new DropShadow();
			borderGlow.setOffsetY(0f);
			borderGlow.setOffsetX(0f);
			borderGlow.setColor(Color.RED);
			borderGlow.setWidth(depth);
			borderGlow.setHeight(depth);
			  
			myObject.setEffect(borderGlow); //Apply the borderGlow effect to the JavaFX node
        }
        else {
       	 	myObject.setEffect(null);
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
		
		myObject.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			
			 @Override
             public void handle(MouseEvent event) {
                 isActive = !isActive;
             }
		});
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
	
	public void setPenColor(Color color) {
		myPenColor = color;
	}
	
	public Boolean getIsDrawing() {
		return isDrawing;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
}
