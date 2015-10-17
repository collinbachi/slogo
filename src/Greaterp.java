
public class Greaterp extends booleanState implements returnsBoolean{
	
	public Greaterp(returnsValue arg0, returnsValue arg1){
		bool = arg0.returnValue() > arg1.returnValue();
	}

}
