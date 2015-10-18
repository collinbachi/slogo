package syntax_tree;

public class Sin extends valueState{
	
	public Sin(returnsValue arg0){
		value = Math.sin(arg0.returnValue());
	}

}
