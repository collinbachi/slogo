
public class Or extends booleanState implements returnsBoolean{
	
	public Or(returnsBoolean arg0, returnsBoolean arg1){
		bool = arg0.returnBoolean() || arg1.returnBoolean();
	}

}
