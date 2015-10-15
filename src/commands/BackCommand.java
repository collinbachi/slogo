package commands;

import drawable.Drawable;

public class BackCommand implements Command {
	private int distance;
	
	public BackCommand(int distance){
		this.distance = distance;
	}

	@Override
	public void execute(Drawable object) {
		// TODO Auto-generated method stub
//		object.back(distance);

	}

}
