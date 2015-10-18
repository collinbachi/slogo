package SLOGO;



import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SLOGOApplication extends Application {

	private static final String DEFAULT_UI_TEXT_RESOURCES_PATH = "UIText";
	private static ResourceBundle myUITextResources = ResourceBundle.getBundle(DEFAULT_UI_TEXT_RESOURCES_PATH);
	public static final String TITLE = myUITextResources.getString("Title");

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	public static final double W_UNIT = WIDTH / 100;
	public static final double H_UNIT = HEIGHT / 100;
    public static final double SECOND_DELAY = 0.025;
    private SLOGOManager mySLOGOManager;
    
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		this.mySLOGOManager = new SLOGOManager();
		Scene scene = this.mySLOGOManager.init(primaryStage, WIDTH,HEIGHT);
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		KeyFrame frame = new KeyFrame(Duration.seconds(SECOND_DELAY),
                e -> this.mySLOGOManager.update(SECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		this.mySLOGOManager.setAnimation(animation);
		animation.play();
		
	}
	
}
