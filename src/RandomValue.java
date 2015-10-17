import java.util.Random;

public class RandomValue extends valueState {

	Random random;

	public RandomValue(returnsValue arg0) {
		value = random.nextDouble()*arg0.returnValue();
	}

}
