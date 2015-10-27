package client;


import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import slogo.SLOGOManager;
import view.ApplicationView;
import view.ConcreteView;
import view.View;

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

	//handleKeyPressed, handleKeyReleased, handleMouseInput,
	
	public abstract void update(double elapsedTime);
	
	public abstract void handleKeyReleased(KeyCode code);
	
	public abstract void handleKeyPressed(KeyCode code);
	
	public abstract void handleMouseInput (double x, double y);
	
	public void setSection(SLOGOSection section){
		this.myManager.setSection(section);
	}
	
}
