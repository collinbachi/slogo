package Client;

import java.util.ResourceBundle;

import SLOGO.SLOGOManager;
import View.ApplicationView;
import View.ConcreteView;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public abstract class SLOGOSection {
	//an abstract class with a protected reference to SLOGOManager 
	//and abstract update and handle input methods: 
	
	protected SLOGOManager myManager;

	protected final View myView;

	protected ApplicationView myApplicationView; 
	
	public SLOGOSection(SLOGOManager manager){
		myView = new ConcreteView();
		myManager = manager;
		myManager.addToRoot(getViewRoot());
		myApplicationView = null;
	}

	public Group getViewRoot () {
		return myView.getRoot();
	}

	public String getTitle() {
		if (myApplicationView == null) {
			return "";
		}
		return myApplicationView.getTitle();
	}
	
	//handleKeyPressed, handleKeyReleased, handleMouseInput,
	
	public abstract void update(double elapsedTime);
	
	public abstract void handleKeyReleased(KeyCode code);
	
	public abstract void handleKeyPressed(KeyCode code);
	
	public abstract void handleMouseInput (double x, double y);
	
	public void setSection(SLOGOSection section){
		this.myManager.setSection(section);
	}
	
}
