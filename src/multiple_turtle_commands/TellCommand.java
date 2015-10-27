package multiple_turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class TellCommand implements ParserCommand {
	private double[] turtles;
	
	public TellCommand(double[] turtles){
		this.turtles = turtles;
	}

	@Override
	public double set(Drawable obj) {
		// TODO:
		return turtles[turtles.length - 1];
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		// reference turtle set
		// if !turtleSet.contains(turtles[i])
		// 		create new turtle at home location;
	}

}
