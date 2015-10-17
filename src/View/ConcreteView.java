package View;

import SLOGO.SLOGOApplication;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

public class ConcreteView implements View {
	
	protected Group myRoot;

	public ConcreteView () {
		this.myRoot = new Group();
	}

	// View functions

	public double X(double x) {
		return SLOGOApplication.W_UNIT * x;
	}

	public double Y(double y) {
		return SLOGOApplication.H_UNIT *((SLOGOApplication.HEIGHT / SLOGOApplication.H_UNIT) - y);
	}

	public double W(double w) {
		return X(w);
	}

	public double H(double h) {
		return X(h);
	}

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

}