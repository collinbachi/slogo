
public class And extends booleanState implements returnsBoolean{
	
	public And(returnsBoolean arg0, returnsBoolean arg1){
		bool = arg0.returnBoolean() && arg1.returnBoolean();
	}

}
