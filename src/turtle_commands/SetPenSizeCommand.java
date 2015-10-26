package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

public class SetPenSizeCommand implements ParserCommand {
	private double pixels;
	
	public SetPenSizeCommand(double pixels){
		this.pixels = pixels;
	}
	
	@Override
	public double set(Drawable obj) {
		obj.setPenSize(pixels);
		return pixels;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
