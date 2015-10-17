package commands;
import java.util.HashSet;

import drawable.Drawable;

public class ForwardCommand implements Command {
	private double distance;
	
	public ForwardCommand(double distance){
		this.distance = distance;
	}

	@Override
	public double execute(Drawable object) {
//		object.forward(distance);
		return distance;
	}
	
	public boolean uniqueCharacters(String word){
		if(word.isEmpty()){
			return true;
		}
		
		HashSet<Character> characters = new HashSet<Character>();
	 	for(int i = 0; i < word.length(); i++){
	 		char c = word.charAt(i);
			if(characters.contains(c)){
				return false;
			}
			else{
				characters.add(c);
			}
	 	}
	 	
	 	String poop = "";
	 	
	 	StringBuilder str = new StringBuilder(poop);

	 	return true;

	}
}
