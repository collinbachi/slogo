package multiple_turtle_commands;

import java.util.List;

import Drawable.Drawable;
import Parser.ParserCommand;

public class AskCommand implements ParserCommand {
	private List<Drawable> turtles;
	private List<ParserCommand> commands;
	
	public AskCommand(List<Drawable> turtles, List<ParserCommand> commands){
		this.turtles = turtles;
		this.commands = commands;
	}

	@Override
	public double set(Drawable obj) {
		// TODO Auto-generated method stub
		// send the commands list to each turtle's queue
		return 0;
	}

	@Override
	public void draw(Drawable obj) {
		// TODO Auto-generated method stub
		return;
	}

}
