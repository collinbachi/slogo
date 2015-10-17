
public class Lessp extends booleanState implements returnsBoolean{
	
	public Lessp(returnsValue arg0, returnsValue arg1){
		bool = arg0.returnValue() < arg1.returnValue();
	}

}
