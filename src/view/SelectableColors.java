package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class SelectableColors {
	private List<Color> colors;
	
	public SelectableColors(){
		colors = new ArrayList<Color>();
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
	}
	
	public List<Color> getColors(){
		return colors;
	}
	
	public void addColor(){
		ColorPalette cp = new ColorPalette();
		cp.getColorPicker().show();
		cp.getColorPicker().setOnAction(e->handleButtonChooseColor(cp.getColorPicker()));
		
	}
	
	private void handleButtonChooseColor(ColorPicker cp){
		colors.add(cp.getValue());
		cp.hide();
	}

}
