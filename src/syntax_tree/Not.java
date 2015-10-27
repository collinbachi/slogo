package syntax_tree;

public class Not extends valueState {
	
	public Not(returnsValue arg0){
		if(arg0.returnValue() == 1){
			value = 0;
		}else{
			value = 1; 
		}
	}

}
