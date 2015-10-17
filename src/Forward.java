
public class Forward extends commandState {
	
	private double arg0;

	public Forward(returnsValue arg0){
		this.arg0 = arg0.returnValue();

		for(int i = 0; i < this.arg0; i++){
			appendToCommandList("Forward");
		}

	}
	

}
