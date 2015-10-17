
public class Equalp extends booleanState implements returnsBoolean{
	
	public Equalp(returnsValue arg0, returnsValue arg1){
		bool = arg0.returnValue() == arg1.returnValue();
	}

}
