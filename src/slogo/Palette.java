package slogo;

import java.util.HashMap;
import java.util.Map;

public class Palette {
	private Map<Double, Double[]> paletteMap;
	
	public Palette(){
		paletteMap = new HashMap<Double, Double[]>();
		paletteMap.put(1.0, new Double[]{255.0, 0.0, 0.0});
		paletteMap.put(2.0, new Double[]{0.0, 255.0, 0.0});
		paletteMap.put(3.0, new Double[]{0.0, 0.0, 255.0});
	}
	
	public void addColor(double index, double r, double g, double b ){
		if(r >= 0 && r < 256 && g >= 0 && g < 256 && b >= 0 && b < 256 ){
			paletteMap.put(index, new Double[]{r, g, b});
		}
	}
}
