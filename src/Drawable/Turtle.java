package Drawable;

import java.util.ArrayDeque;
import java.util.Queue;

import Client.DrawingBoard;
import Drawable.DrawCommand.*;
import Parser.ParserCommand;
import Parser.ParserCommandMoveForward;

public class Turtle implements Drawable {
	
	private DrawingBoard myBoard;
	
	private Queue<ParserCommand> myCommands;

	double myX;
	double myY;
	double myHeading;
	Boolean myPenUp;
	Boolean myShowing;
	
	private static final String mySpriteFileName = "turtle.jpg";
	private static final double myMoveSpeed = 50;
	private static final double myTurnSpeed = 30;

	public Turtle (DrawingBoard board) {
		myCommands = new ArrayDeque<>();
		myBoard = board;
		myX = 0;
		myY = 0;
		myHeading = 120;
		myShowing = true;
		myPenUp = false;
		
		DrawCommand start = new DrawCommandInitObject(mySpriteFileName, myX, myY, myHeading);
		myBoard.drawCommand(start);
		
		//For testing
		
		ParserCommand move = new ParserCommandMoveForward(300);
		runCommand(move);
		
	}

	// Core functions

	public void animate() {
		while (myCommands.size() != 0) {
			ParserCommand cmd = myCommands.poll();
			cmd.draw(this);
		}
	}

	// Drawable functions

	@Override
	public double setShowing(Boolean state) {
		myShowing = state;
		if (state) {
			return 1;
		}
		return 0;
		
	}

	@Override
	public double setForward(double amt) {
		myX += Math.cos(Math.toRadians(90 - myHeading)) * amt;
		myY += Math.sin(Math.toRadians(90 - myHeading)) * amt;
		return amt;
	}

	@Override
	public double setBack(double amt) {
		return setForward(-1 * amt);	
	}

	@Override
	public double setLeft(double degrees) {
		myHeading -= degrees;
		return degrees;	
	}

	@Override
	public double setRight(double degrees) {
		return setLeft( -1 * degrees);
	}

	@Override
	public double setHeading(double degrees) {
		myHeading = degrees;
		return degrees;
	}

	@Override
	public double setTowards(double x, double y) {
		// TODO DO LATER!
		return 0;
	}
	
	@Override
	public double setXY(double x, double y) {
		double distance = Math.sqrt(Math.pow(myX - x, 2) + Math.pow(myY - y, 2));
		myX = x;
		myY = y;
		return distance;
	}

	@Override
	public double setPen(Boolean state) {
		myPenUp = state;
		if (state) {
			return 1;
		}
		return 0;
	}

	@Override
	public double setToHome() {
		return setXY(0,0);
	}

	@Override
	public double setClearScreen() {
		return setXY(0,0);
	}

	@Override
	public void drawShowing(Boolean state) {
		DrawCommand cmd = new DrawCommandDrawShowing(state);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawForward(double amt) {
		DrawRequest cmdx = new DrawCommandGetX();
		double x = myBoard.drawRequest(cmdx);
		
		DrawRequest cmdy = new DrawCommandGetY();
		double y = myBoard.drawRequest(cmdy);
		
		DrawRequest cmdh = new DrawCommandGetHeading();
		double h = myBoard.drawRequest(cmdh);
		
		double newX = x + Math.cos(Math.toRadians(90 - h))*amt;
		double newY = y - Math.sin(Math.toRadians(90 - h))*amt;
		// amount is subtracted because we have already flipped the y coordinate upside-down in the view when we get it here
		
		DrawCommand cmd = new DrawCommandDrawMove(newX, newY, myMoveSpeed);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawBack(double amt) {
		drawForward(-1 * amt);
	}

	@Override
	public void drawLeft(double degrees) {
		DrawRequest cmdh = new DrawCommandGetHeading();
		double h = myBoard.drawRequest(cmdh);
		
		double newHeading = h - degrees;
		
		DrawCommand cmd = new DrawCommandDrawTurn(newHeading, myTurnSpeed);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawRight(double degrees) {
		drawLeft(-1 * degrees);
	}

	@Override
	public void drawHeading(double degrees) {
		DrawCommand cmd = new DrawCommandDrawTurn(degrees, myTurnSpeed);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawTowards(double x, double y) {
		// TODO DO LATER!
		
	}

	@Override
	public void drawXY(double x, double y) {
		DrawCommand cmd = new DrawCommandDrawMove(x, y, myMoveSpeed);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawPen(Boolean state) {
		DrawCommand cmd = new DrawCommandDrawPen(state);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawToHome() {
		DrawCommand cmd = new DrawCommandDrawMove(0, 0, myMoveSpeed);
		myBoard.drawCommand(cmd);
	}

	@Override
	public void drawClearScreen() {
		DrawCommand cmdm = new DrawCommandDrawMove(0, 0, myMoveSpeed);
		myBoard.drawCommand(cmdm);
		DrawCommand cmdc = new DrawCommandDrawClear();
		myBoard.drawCommand(cmdc);
	}

	@Override
	public double getX() {
		return myX;
	}

	@Override
	public double getY() {
		return myY;
	}

	@Override
	public double getHeading() {
		return myHeading;
	}

	@Override
	public Boolean getPenUp() {
		return myPenUp;
	}

	@Override
	public Boolean getShowing() {
		return myShowing;
	}

	@Override
	public void addAnimationToQueue(ParserCommand cmd) {
		myCommands.add(cmd);
	}

	@Override
	public double runCommand(ParserCommand cmd) {
		addAnimationToQueue(cmd);
		return cmd.set(this);
	}
}