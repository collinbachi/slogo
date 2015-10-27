package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface ApplicationView {

	// All display for the core application is done through this interface
	// (e.g. button creation, text box display, etc.)

	String getTitle();
	
	// Initialize Button
	Button initButton(String name, Image image, double x, double y);
	
	Button initButton(String name, double x, double y);
	
	Button initButton(Image image, double x, double y);
	
	Button initButton(String name, EventHandler<ActionEvent> handler);

}