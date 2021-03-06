package parser;

import drawable.Drawable;

public interface ParserCommand {

	// The parser calls commands that implement this interface, and sends them to the client, which sends them to a Drawable object.

	// When set() is called, the command should call setCMD, and then addAnimationToQueue()
	public double set(Drawable obj);

	// When execute() is called, the command should call drawCMD
	public void draw(Drawable obj);
}