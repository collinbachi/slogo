package SLOGO;

import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SLOGOManager {

	//The SLOGOManager class contains the references to the the Scene, Group, and SLOGOSection being displayed. 
	//The SLOGOManager class will also contain a setScreen method which 
	//one can use to change the current screen.
	public static final String DEFAULT_UI_TEXT_RESOURCES_PATH = "UIText";
    public ResourceBundle myUITextResources = ResourceBundle.getBundle(DEFAULT_UI_TEXT_RESOURCES_PATH);
	public String TITLE = myUITextResources.getString("Title");
	
	private Scene myScene;
	private Group myRoot;
	private SLOGOSection mySection; // Holds the different "sections" of the application. Currently there is just the library/text_input/drawing board section.
	private Stage myStage;
	private Timeline myAnimation;
	
	
	public Scene init(Stage stage, int width, int height){
		
		this.myStage = stage;
		this.myRoot = new Group();
		this.myScene = new Scene(myRoot,width,height,Color.WHITE);
		this.mySection = new OptionSelectScreen(this);
		this.myScene.setOnKeyPressed(e -> handleKeyPressed(e.getCode()));
		this.myScene.setOnKeyReleased(e -> handleKeyReleased(e.getCode()));
		this.myScene.setOnMouseClicked(e -> handleMouseInput(e.getSceneX(), e.getSceneY()));
		return myScene;
	}
	
	public Stage getStage(){
		return this.myStage;
	}
	
	public void setAnimation(Timeline animation){
		this.myAnimation = animation;
	}
	
	private void handleKeyReleased(KeyCode code){
		this.mySection.handleKeyReleased(code);
	}
	
	private void handleKeyPressed(KeyCode code){
		this.mySection.handleKeyPressed(code);
	}
	
	private void handleMouseInput (double x, double y){
		this.mySection.handleMouseInput(x, y);
	}
	
	public void update(double elapsedTime){
		this.mySection.update(elapsedTime);
	}
	
	public String getTitle () {
        return TITLE;
    }
		
	public void setSection(SLOGOSection section){
		//change the current screen
		this.mySection = section;
	}
	
	public void addToRoot(Node node, int i){
		this.myRoot.getChildren().add(i, node);
	}
	
	public void addToRoot(Node node) {
		// TODO Auto-generated method stub
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
	
	public void setStageWidth(double width){
		this.myStage.setWidth(width);
	}
	
	public void setStageHeight(double height){
		this.myStage.setHeight(height);
	}
	
	public void resetTime(double secondsDelay){
		KeyFrame frame = new KeyFrame(Duration.seconds(secondsDelay),
                e -> this.update(secondsDelay));
		this.myAnimation.stop();
		this.myAnimation.getKeyFrames().clear();
		this.myAnimation.getKeyFrames().add(frame);
		this.myAnimation.play();
	}
}
