package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class SetBackgroundCommand implements ParserCommand {
	private double index;
	
	public SetBackgroundCommand(double index){
		this.index = index;
	}
	@Override
	public double set(Drawable obj) {
		obj.setBackground(index);
		return index;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		obj.drawBackground(index);
	}

}
