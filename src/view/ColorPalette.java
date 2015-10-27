package view;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class ColorPalette extends ConcreteView {
	
	private static final double CP_X = 95;
	private static final double CP_Y = 95;
	private static final double CP_W = 25;
	private static final double CP_H = 65;
	
	private ColorPicker cp;
	
	public ColorPalette(){
		super();
		this.cp = new ColorPicker(Color.BLUE);
		cp.setLayoutX(X(CP_X));
		cp.setLayoutY(Y(CP_Y));
		cp.setPrefWidth(W(CP_W));
		cp.setPrefHeight(H(CP_H));
	}
	
	public ColorPicker getColorPicker(){
		return cp;
	}
}
