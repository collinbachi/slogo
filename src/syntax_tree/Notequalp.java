package syntax_tree;

public class Notequalp extends valueState {
	
	public Notequalp(returnsValue arg0, returnsValue arg1){
		if(arg0.returnValue() != arg1.returnValue()){
			value = 1;
		}else{
			value = 0; 
		}
	}

}
