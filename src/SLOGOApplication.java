package SLOGO;


import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SLOGOApplication extends Application {

	
	public static final int WIDTH = 700;
	public static final int HEIGHT = 800;
    public static final double SECOND_DELAY = 1.0;
    private SLOGOManager mySLOGOManager;
    
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		this.mySLOGOManager = new SLOGOManager();
		primaryStage.setTitle(this.mySLOGOManager.getTitle());
		Scene scene = this.mySLOGOManager.init(primaryStage, WIDTH,HEIGHT);
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
