package syntax_tree;

public class Lessp extends valueState implements returnsValue{
	
	public Lessp(returnsValue arg0, returnsValue arg1){
		if(arg0.returnValue() < arg1.returnValue()){
			value = 1; 
		}else{
			value = 0; 
		}
	}

}
