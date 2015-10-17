package View;

import java.util.ResourceBundle;

import Client.ParserClient;
import Client.SLOGOSection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;


public class ParseAndDrawApplicationView extends ConcreteView implements ApplicationView {

	private TextArea parserText;
	private static final double TBOX_X = 25;
	private static final double TBOX_Y = 75;
	private static final double TBOX_W = 25;
	private static final double TBOX_H = 50;

	private Button evaluate;
	private static final double EVAL_X = 35;
	private static final double EVAL_Y = 10;

	private HBox penSelect;

	private Color myPenColor;

	private ParserClient myClient;

	private View baseView;
	
	public static final String DEFAULT_UI_TEXT_RESOURCES_PATH = "UIText";
	protected static ResourceBundle myUITextResources = ResourceBundle.getBundle(DEFAULT_UI_TEXT_RESOURCES_PATH);
	private static final String EVALUATE = myUITextResources.getString("Evaluate");
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

		this.parserText = new TextArea();
		parserText.setLayoutX(X(TBOX_X));
		parserText.setLayoutY(Y(TBOX_Y));
		parserText.setPrefWidth(W(TBOX_W));
		parserText.setPrefHeight(H(TBOX_H));
		myRoot.getChildren().add(parserText);

		this.evaluate = initButton(EVALUATE, X(EVAL_X), Y(EVAL_Y));	
		System.out.println(X(TBOX_X));
		System.out.println(Y(TBOX_Y));
		evaluate.setOnAction(e->handleButtonEvaluate());	
		myRoot.getChildren().add(evaluate);
	}

	private void handleButtonEvaluate() {
		String text = parserText.getParagraphs().toString();
		parserText.clear();
		myClient.parseText(text);
	}

	// ApplicationView functions

	public String getTitle() {
		return TITLE;
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