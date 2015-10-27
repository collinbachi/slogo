package turtle_commands;

import drawable.Drawable;
import parser.ParserCommand;

public class SetPenColorCommand implements ParserCommand {
	private double index;
	
	public SetPenColorCommand(double index){
		this.index = index;
	}
	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setPenColor(index);
		return index;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}
}
