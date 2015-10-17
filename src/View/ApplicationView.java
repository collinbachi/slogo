package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface ApplicationView {

	// All display for the core application is done through this interface
	// (e.g. button creation, text box display, etc.)

	String getTitle();
	
	void setImageViewPosition(ImageView imageView, double x, double y);
	
	// Initialize ImageView
	ImageView initImageView(Image image, double x, double y);
	
	// Get an Image
	Image getImage(String imageName);
	
	// Initialize Button
	Button initButton(String name, Image image, double x, double y);
	
	Button initButton(String name, double x, double y);
	
	Button initButton(Image image, double x, double y);
	
	Button initButton(String name, EventHandler<ActionEvent> handler);

}