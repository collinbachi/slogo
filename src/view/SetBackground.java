package view;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class SetBackground extends ConcreteView {
	private static final double BACKGC_X = 95;
	private static final double BACKGC_Y = 75;
	private static final double BACKGC_W = 25;
	private static final double BACKGC_H = 65;
	
	private ComboBox<Color> penColors;
	
	public SetBackground(){
		super();
		this.penColors = new ComboBox<Color>();
		penColors.setLayoutX(X(BACKGC_X));
		penColors.setLayoutY(Y(BACKGC_Y));
		penColors.setPrefWidth(W(BACKGC_W));
		penColors.setPrefHeight(H(BACKGC_H));
		penColors.getItems().addAll(new SelectableColors().getColors());
	}
	
	public ComboBox<Color> getColorPicker(){
		return penColors;
	}

}
