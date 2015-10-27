package slogo;

import java.util.HashSet;
import java.util.Set;

public class StampSet {
	private Set<Stamp> stamps;
	public StampSet(){
		stamps = new HashSet<Stamp>();
		
	}
	
	public void addStamp(Stamp s){
		stamps.add(s);
	}
	
	public double clearStamps(){
		double ret = !stamps.isEmpty() ? 1 : 0;
		stamps.clear();
		return ret;
	}
}
