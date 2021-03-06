package view;

import java.util.List;

import drawable.DrawCommand;
import drawable.DrawRequest;
import javafx.scene.paint.Color;

public interface DrawView {

	// All animation actions done to the drawable object are called through this interface

	void drawMove(double x, double y, double speed);

	void drawTurn(double degree, double speed);

	void drawPen(Boolean state);

	void drawShowing(Boolean state);

	void drawClear();

	double getX();

	double getY();

	double getHeading();

	void executeCommand(int i, DrawCommand cmd);

	double executeRequest(int i, DrawRequest cmd);
	
	void initObject(String filename, double x, double y, double orientation);

	void setPenColor(Color color);
	
	void update();
	
}