package syntax_tree;
import java.util.ArrayList;
import java.util.HashSet;

public class mathFactory extends valueState implements returnsValue{
	
	private String currentInput;
	
	public mathFactory(HashSet<String> mathSet, ArrayList<String> inputCommands){
		
		currentInput = inputCommands.remove(0);
		mathFactory expression0;
		mathFactory expression1;
		
		if(mathSet.contains(currentInput)){
			switch(currentInput){
				case "SUM":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Sum(expression0, expression1).returnValue();
					break;

				case "DIFFERENCE":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Difference(expression0, expression1).returnValue();
					break;

				case "PRODUCT":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Product(expression0, expression1).returnValue();
					break;

				case "QUOTIENT":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Quotient(expression0, expression1).returnValue();
					break;

				case "REMAINDER":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Remainder(expression0, expression1).returnValue();
					break;

				case "MINUS":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Minus(expression0).returnValue();

					break;
				case "RANDOM":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new RandomValue(expression0).returnValue();
					break;

				case "SIN":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Sin(expression0).returnValue();
					break;

				case "COS":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Cos(expression0).returnValue();
					break;
				
				case "TAN":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Tan(expression0).returnValue();
					break;
				
				case "ATAN":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Atan(expression0).returnValue();
					break;
					
				case "LOG":
					expression0 = new mathFactory(mathSet, inputCommands);
					value = new Log(expression0).returnValue();
					break;
					
				case "POW":
					expression0 = new mathFactory(mathSet, inputCommands);
					expression1 = new mathFactory(mathSet, inputCommands);
					value = new Power(expression0, expression1).returnValue();
					break;
					
				case "PI":
					value = new Pi().returnValue();
					break;
			}
		}else{
			try{
				int num = Integer.parseInt(currentInput); 
				value = new Constant(num).returnValue();
			} catch (NumberFormatException e){
				System.out.println("Improperly formatted integer, defaulting to 0");
			}
		}
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
