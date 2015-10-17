
public class Notequalp extends booleanState implements returnsBoolean{
	
	public Notequalp(returnsValue arg0, returnsValue arg1){
		bool = arg0.returnValue() != arg1.returnValue();
	}

}
