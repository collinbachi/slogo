package commands;
import drawable.Drawable;

public class ForwardCommand implements Command {
	private int distance;
	
	public ForwardCommand(int distance){
		this.distance = distance;
		
	}

	@Override
	public void execute(Drawable object) {
//		object.forward(distance);
	}
}
