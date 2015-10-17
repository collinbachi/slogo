package Client;

import Parser.ParserCommand;

public interface ParserClient {

	// The general application manager implements this, is passed into parser as type ParserClient.
	// This is how the parser interacts with the manager.

	void handleParseError (String error);

	void parseText(String text);

	double getX();

	double getY();

	double getHeading();

	Boolean getPenUp();

	Boolean getShowing();

	double postCommand(ParserCommand cmd);

}