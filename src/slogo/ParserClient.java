package slogo;

import turtle_commands.ParserCommand;

public interface ParserClient {

	// The general application manager implements this, is passed into parser as type ParserClient.
	// This is how the parser interacts with the manager.

	double getX();

	double getY();

	double getHeading();

	Boolean getPenUp();

	Boolean getShowing();

	void postCommand(ParserCommand cmd);

}