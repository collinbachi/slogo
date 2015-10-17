package commands;

import drawable.Drawable;

public class PenDownCommand implements Command {
	
	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
		object.penDown();
		return 1;
	}
}
