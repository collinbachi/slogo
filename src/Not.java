
public class Not extends booleanState implements returnsBoolean{
	
	public Not(returnsBoolean arg0){
		bool = !arg0.returnBoolean();
	}

}
