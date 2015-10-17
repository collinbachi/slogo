package commands;

import drawable.Drawable;

public class PenUpCommand implements Command {

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
		object.penUp();
		return 0;
	}
}
