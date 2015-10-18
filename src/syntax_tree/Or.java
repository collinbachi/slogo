package syntax_tree;

public class Or extends valueState implements returnsValue{
	
	public Or(returnsValue arg0, returnsValue arg1){
		if((arg0.returnValue() == 1) || (arg1.returnValue() == 1)){
			value = 1;
		}else{
			value = 0; 
		}

	}

}
