
public class Constant implements returnsValue{
	
	private double value;
	
	public Constant(int input){
		value = input; 
	}

	@Override
	public double returnValue() {
		return value;
	}
	
}
