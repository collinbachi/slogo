package view;

import client.SLOGOSection;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import slogo.SLOGOApplication;

public class ConcreteView implements View {
	
	protected Group myRoot;

	public ConcreteView () {
		this.myRoot = new Group();
	}
	
	// These four functions handle the transforms between numbered entered and coordinates displayed onscreen.


	protected double X(double x) {
		return SLOGOApplication.W_UNIT * x;
	}

	protected double Y(double y) {
		return SLOGOApplication.H_UNIT *((SLOGOApplication.HEIGHT / SLOGOApplication.H_UNIT) - y);
	}

	protected double W(double w) {
		return X(w);
	}

	protected double H(double h) {
		return X(h);
	}
	
	// View functions


	public Group getRoot() {
		return myRoot;
	}

	public void addToRoot(Node node, int i){
		this.myRoot.getChildren().add(i, node);
	}
	
	public void addToRoot(Node node) {
		this.myRoot.getChildren().add(node);
	}
	
	public void removeFromRoot(Node node){
		this.myRoot.getChildren().remove(node);
	}
	
	public int removeFromRootInt(Node node){
		ObservableList<Node> nodeList = this.myRoot.getChildren();
		int result = nodeList.indexOf(node);
		nodeList.remove(node);
		return result;
	}
	
	public void clearRoot(){
		this.myRoot.getChildren().clear();
	}
	
	public void setImageViewPosition(ImageView imageView, double x, double y){
		imageView.setX(x);
		imageView.setY(y);
	}

	public ImageView initImageView(Image image, double x, double y){
		ImageView result = new ImageView(image);
		setImageViewPosition(result,x,y);
		return result;
	}

	public Image getImage(String imageName){
		return new Image(SLOGOSection.class.getClassLoader().getResourceAsStream(imageName));
	}

}