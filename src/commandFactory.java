import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class commandFactory implements returnsCommandList, returnsValue, returnsBoolean{
	private ArrayList<String> commandList = new ArrayList<String>();
	private double value;
	private String currentInput;
	private boolean bool;
	
	private Set<String>  commandSet;
	private Set<String>  mathSet;
	private Set<String>  booleanSet;
	private List<String> inputCommands;

	public commandFactory(Set<String> commandSet, Set<String> mathSet, Set<String> booleanSet, List<String> inputCommands) {
		this.commandSet    = commandSet;
		this.mathSet 	   = mathSet;
		this.booleanSet    = booleanSet;
		this.inputCommands = inputCommands; 

		currentInput = inputCommands.remove(0);
		if (commandSet.contains(currentInput)) {
			switch (currentInput) {

				case "REPEAT":
					Repeat newRepeat 		  = new Repeat(recurse(), recurse());
					getCommandList().addAll(newRepeat.getCommandList());
					break;

				case "FD":
					Forward newForward 		  = new Forward(recurse());
					getCommandList().addAll(newForward.getCommandList());
					break;

				case "[":
					getCommandList().addAll(recurse().getCommandList());
					break;
				
				case "]":
					break;
			}
		}else if(mathSet.contains(currentInput)){
			switch(currentInput){
				case "SUM":
					value = new Sum(recurse(), recurse()).returnValue();
					break;

				case "DIFFERENCE":
					value = new Difference(recurse(), recurse()).returnValue();
					break;

				case "PRODUCT":
					value = new Product(recurse(), recurse()).returnValue();
					break;

				case "QUOTIENT":
					value = new Quotient(recurse(), recurse()).returnValue();
					break;

				case "REMAINDER":
					value = new Remainder(recurse(), recurse()).returnValue();
					break;

				case "MINUS":
					value = new Minus(recurse()).returnValue();

					break;
				case "RANDOM":
					value = new RandomValue(recurse()).returnValue();
					break;

				case "SIN":
					value = new Sin(recurse()).returnValue();
					break;

				case "COS":
					value = new Cos(recurse()).returnValue();
					break;
				
				case "TAN":
					value = new Tan(recurse()).returnValue();
					break;
				
				case "ATAN":
					value = new Atan(recurse()).returnValue();
					break;
					
				case "LOG":
					value = new Log(recurse()).returnValue();
					break;
					
				case "POW":
					value = new Power(recurse(), recurse()).returnValue();
					break;
					
				case "PI":
					value = new Pi().returnValue();
					break;
			}
		}else if(booleanSet.contains(currentInput)){
			switch(currentInput){
				case "LESSP":
					bool = new Lessp(recurse(), recurse()).returnBoolean();
					break;
			
				case "GREATERP":
					bool = new Greaterp(recurse(), recurse()).returnBoolean();
					break;

				case "EQUALP":
					bool = new Equalp(recurse(), recurse()).returnBoolean();
					break;
					
				case "NOTEQUALP":
					bool = new Notequalp(recurse(), recurse()).returnBoolean();
					break;

				case "AND":
					bool = new And(recurse(), recurse()).returnBoolean();
					break;

				case "OR":
					bool = new Lessp(recurse(), recurse()).returnBoolean();
					break;

				case "NOT":
					bool = new Lessp(recurse(), recurse()).returnBoolean();
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
	
	private commandFactory recurse(){
		return new commandFactory(this.commandSet, this.mathSet, this.booleanSet, this.inputCommands);
	}

	@Override
	public ArrayList<String> getCommandList() {
		// TODO Auto-generated method stub
		return commandList;
	}

	@Override
	public void appendToCommandList(String s) {
		// TODO Auto-generated method stub
		commandList.add(s);
		
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public boolean returnBoolean() {
		// TODO Auto-generated method stub
		return bool;
	}
}
