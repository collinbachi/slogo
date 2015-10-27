package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface View {
	
	// The base functions every view object implements

	Group getRoot();

	void addToRoot(Node node, int i);
	
	void addToRoot(Node node);
	
	void removeFromRoot(Node node);
	
	int removeFromRootInt(Node node);
	
	void clearRoot();
	
	void setImageViewPosition(ImageView imageView, double x, double y);
	
	// Initialize ImageView
	ImageView initImageView(Image image, double x, double y);
	
	// Get an Image
	Image getImage(String imageName);

}