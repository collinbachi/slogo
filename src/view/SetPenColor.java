package view;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class SetPenColor extends ConcreteView{
	private static final double PENC_X = 95;
	private static final double PENC_Y = 75;
	private static final double PENC_W = 25;
	private static final double PENC_H = 65;
	
	private ComboBox<Color> penColors;
	
	public SetPenColor(){
		super();
		this.penColors = new ComboBox<Color>();
		penColors.setLayoutX(X(PENC_X));
		penColors.setLayoutY(Y(PENC_Y));
		penColors.setPrefWidth(W(PENC_W));
		penColors.setPrefHeight(H(PENC_H));
		penColors.getItems().addAll(new SelectableColors().getColors());
	}
	
	public ComboBox<Color> getColorPicker(){
		return penColors;
	}

}
