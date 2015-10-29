package syntax_tree;

public class Equalp extends valueState {
	
	public Equalp(returnsValue arg0, returnsValue arg1){
		if(arg0.returnValue() == arg1.returnValue()){
			value = 1;
		}else{
			value = 0;
		}
	}

}
