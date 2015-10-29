package slogo;


import java.util.HashMap;
import java.util.Map;

public class VariableMap{
	private Map<String, Double> vmap;
	
	public VariableMap(){
		vmap = new HashMap<String, Double>();
	}
	
	public double getValue(String key){
		if(vmap.containsKey(key)){
			return vmap.get(key);
		}

		return Double.NaN;	
	}
	
	public void setVariable(String key, double value){
			vmap.put(key, value);
	}
}
