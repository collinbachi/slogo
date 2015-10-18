
public class And extends valueState implements returnsValue{
	
	public And(returnsValue arg0, returnsValue arg1){
		if((arg0.returnValue() == 1) && (arg1.returnValue() == 1)){
			value = 1;
		}else{
			value = 0; 
		}
	}

}
