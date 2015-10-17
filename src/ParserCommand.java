package SLOGO;



public interface ParserCommand {

	// The parser calls commands that implement this interface, and sends them to the client, which sends them to a Drawable object.

	// When set() is called, the command should call setCMD, and then addAnimationToQueue()
	public void set(Drawable obj);

	// When execute() is called, the command should call drawCMD
	public void draw(Drawable obj);
}