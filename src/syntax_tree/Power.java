package syntax_tree;

public class Power extends valueState{
	
	public Power(returnsValue arg0, returnsValue arg1){
		value = Math.pow(arg0.returnValue(), arg1.returnValue());
	}

}
