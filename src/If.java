
public class If extends commandState{

	public If(returnsValue arg0, returnsCommandList arg1){
		if(arg0.returnValue() == 1){
			getCommandList().addAll(arg1.getCommandList()); 
		}
	}
}
