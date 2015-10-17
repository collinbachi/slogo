
public class Sum extends valueState{
	
	public Sum(returnsValue arg0, returnsValue arg1){
		value = arg0.returnValue() + arg1.returnValue();
	}

}
