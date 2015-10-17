
public class Difference extends valueState{
	
	public Difference(returnsValue arg0, returnsValue arg1){
		value = arg0.returnValue() - arg1.returnValue();
	}

}
