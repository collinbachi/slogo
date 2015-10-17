package View;

import javafx.scene.Group;
import javafx.scene.Node;

public interface View {
	
	// The base functions every view object implements

	// These four functions handle the transforms between numbered entered and coordinates displayed onscreen.

	double X(double x);

	double Y(double y);

	double W(double w);

	double H(double h);



	Group getRoot();

	void addToRoot(Node node, int i);
	
	void addToRoot(Node node);
	
	void removeFromRoot(Node node);
	
	int removeFromRootInt(Node node);
	
	void clearRoot();

}