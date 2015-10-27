package view;

import java.util.ResourceBundle;

import client.ParserClient;
import client.SLOGOSection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import slogo.SLOGOApplication;
import sun.security.tools.keytool.Main;
import javafx.scene.image.Image;


public class ParseAndDrawApplicationView extends ConcreteView implements ApplicationView {

	private Rectangle applicationArea;
	private static final double APP_X = 0;
	private static final double APP_Y = 100;
	private static final double APP_W = 35;
	private static final double APP_H = 100;
	private static final Color APP_COLOR = Color.LIGHTGRAY;

	private TextArea parserText;
	private static final double TBOX_X = 5;
	private static final double TBOX_Y = 95;
	private static final double TBOX_W = 25;
	private static final double TBOX_H = 65;

	private Button evaluate;
	private static final double EVAL_X = 22;
	private static final double EVAL_Y = 13;
	
	private Button newInstance;
	private static final double INST_X = 1;
	private static final double INST_Y = 99;
	

	private HBox penSelect;

	private ParserClient myClient;

	private View baseView;
	
	public static final String DEFAULT_UI_TEXT_RESOURCES_PATH = "UIText";
	protected static ResourceBundle myUITextResources = ResourceBundle.getBundle(DEFAULT_UI_TEXT_RESOURCES_PATH);
	private static final String EVALUATE = myUITextResources.getString("Evaluate");
	private static final String NEWINSTANCE = myUITextResources.getString("NewInstance");
	private static final String TITLE = myUITextResources.getString("Title");

	public ParseAndDrawApplicationView (View view, ParserClient client) {
		super();
		myClient = client;
		makeButtonsAndText();
		baseView = view;
		baseView.addToRoot(myRoot);
	}

	// Class-specific functions

	public void makeButtonsAndText() {

		this.applicationArea = new Rectangle();
		applicationArea.setX(X(APP_X));
		applicationArea.setY(Y(APP_Y));
		applicationArea.setWidth(W(APP_W));
		applicationArea.setHeight(H(APP_H));
		applicationArea.setFill(APP_COLOR);
		myRoot.getChildren().add(applicationArea);

		this.parserText = new TextArea();
		parserText.setLayoutX(X(TBOX_X));
		parserText.setLayoutY(Y(TBOX_Y));
		parserText.setPrefWidth(W(TBOX_W));
		parserText.setPrefHeight(H(TBOX_H));
		myRoot.getChildren().add(parserText);

		this.evaluate = initButton(EVALUATE, X(EVAL_X), Y(EVAL_Y));	
//		System.out.println(X(APP_X));
//		System.out.println(Y(APP_Y));
		evaluate.setOnAction(e->handleButtonEvaluate());	
		myRoot.getChildren().add(evaluate);
		
		this.newInstance = initButton(NEWINSTANCE, X(INST_X), Y(INST_Y));
		newInstance.setOnAction(e->handleButtonNewInstance());
		myRoot.getChildren().add(newInstance);
		
	}

	private void handleButtonEvaluate() {
		String text = parserText.getParagraphs().toString();
		parserText.clear();
		myClient.parseText(text);
	}
	
	private void handleButtonNewInstance(){
		try {
			new SLOGOApplication().start(new Stage());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ApplicationView functions

	public String getTitle() {
		return TITLE;
	}

	public Button initButton(String name, Image image, double x, double y){
		Button result;
		if(image!=null){
			result = new Button(name,new ImageView(image));
		}
		else{
			result = new Button(name);
		}
		result.setTranslateX(x);
		result.setTranslateY(y);
		return result;
	}
	
	public Button initButton(String name, double x, double y){
		return initButton(name,null,x,y);
	}
	
	public Button initButton(Image image, double x, double y){
		return initButton("", image, x, y);
	}
	
	public Button initButton(String name, EventHandler<ActionEvent> handler){
		Button result = new Button(name);
		result.setOnAction(handler);
		return result;
	}


}