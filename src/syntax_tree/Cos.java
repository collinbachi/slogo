package syntax_tree;

public class Cos extends valueState{
	
	public Cos(returnsValue arg0){
		value = Math.cos(arg0.returnValue());
	}

}
