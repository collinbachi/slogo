package parser;

import drawable.Drawable;

public class ParserCommandMoveForward implements ParserCommand {
	
	private final double myAmt;

	public ParserCommandMoveForward(double amt) {
		myAmt = amt;
	}

	public double set(Drawable obj) {
		return obj.setForward(myAmt);
	}

	public void draw(Drawable obj) {
		obj.drawForward(myAmt);
	}

}