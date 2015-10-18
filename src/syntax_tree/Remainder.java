package syntax_tree;

public class Remainder extends valueState{
	
	public Remainder(returnsValue arg0, returnsValue arg1){
		value = arg0.returnValue() % arg1.returnValue();
	}

}
