package syntax_tree;

public class Minus extends valueState{
	
	public Minus(returnsValue arg0){
		value = arg0.returnValue()*-1;
	}

}
