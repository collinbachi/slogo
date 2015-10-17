package Drawable;

import Client.DrawingBoard;
import Parser.ParserCommand;

public class Turtle implements Drawable {
	
	private DrawingBoard myBoard;

	double myX;
	double myY;
	double myHeading;
	Boolean myPenUp;
	Boolean myShowing;

	public Turtle (DrawingBoard board) {
		myBoard = board;
		myX = 0;
		myY = 0;
		myHeading = 90;
	}

	@Override
	public void showObj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideObj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setForward(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBack(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLeft(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRight(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeading(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTowards(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPenUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPenDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClearScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawForward(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBack(double amt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawLeft(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawRight(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawHeading(double degrees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTowards(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawXY(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPenUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPenDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawToHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawClearScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeading() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean getPenUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getShowing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAnimationToQueue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runCommand(ParserCommand cmd) {
		// TODO Auto-generated method stub
		
	}
}