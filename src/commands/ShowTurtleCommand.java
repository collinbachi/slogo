package commands;

import drawable.Drawable;

public class ShowTurtleCommand implements Command {

	@Override
	public double execute(Drawable object) {
		// TODO Auto-generated method stub
		object.showObj();
		return 1;
	}

}
