package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

public class SetShapeCommand implements ParserCommand {
	private double index;
	
	public SetShapeCommand(double index){
		this.index = index;
	}
	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setShape(index);
		return index;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
