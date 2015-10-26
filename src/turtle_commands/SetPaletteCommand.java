package turtle_commands;

import Drawable.Drawable;
import Parser.ParserCommand;

public class SetPaletteCommand implements ParserCommand {
	private double index, r, g,	b;
	
	public SetPaletteCommand(double index, double r, double g, double b){
		this.index = index;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		obj.setPalette(index, r, g, b);
		return index;
	}

	@Override
	public void draw(Drawable obj) {
		return;
	}

}
