package slogo;

import java.util.HashSet;
import java.util.Set;

public class StampSet {
	private Set stamps;
	public StampSet(){
		stamps = new HashSet<Stamp>();
		
	}
	
	public double size(){
		return stamps.size();
	}

}
