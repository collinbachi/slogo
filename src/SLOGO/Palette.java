package slogo;

import java.util.HashMap;
import java.util.Map;

public class Palette {
	private Map<Double, Double[]> paletteMap;
	
	public Palette(){
		paletteMap = new HashMap<Double, Double[]>();
	}
	
	public void addColor(double index, double r, double g, double b ){
		if(r >= 0 && r < 256 && g >= 0 && g < 256 && b >= 0 && b < 256 ){
			paletteMap.put(index, new Double[]{r, g, b});
		}
	}
}
