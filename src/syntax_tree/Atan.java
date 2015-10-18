package syntax_tree;

public class Atan extends valueState{
	
	public Atan(returnsValue arg0){
		value = Math.atan(arg0.returnValue());
	}

}
