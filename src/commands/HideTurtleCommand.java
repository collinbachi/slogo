package commands;

import drawable.Drawable;

public class HideTurtleCommand implements Command {

	@Override
	public double execute(Drawable object){
		object.hideObj();
		return 0;
	}

}
