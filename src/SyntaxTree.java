import java.util.ArrayList;
import java.util.HashSet;

public class SyntaxTree {

	private static HashSet<String> commandSet = new HashSet<String>();
	private static HashSet<String> mathSet    = new HashSet<String>();
	private static HashSet<String> booleanSet = new HashSet<String>();

	public static void main(String[] args){
		buildCommandSet();
		buildMathSet();
		buildBooleanSet();
		
		ArrayList<String> inputCommands = new ArrayList<String>();
		inputCommands.add("REPEAT");
		//inputCommands.add("3");
		inputCommands.add("SUM");
		inputCommands.add("4");
		inputCommands.add("3");
		inputCommands.add("[");
		inputCommands.add("FD");
		inputCommands.add("2");
		inputCommands.add("]");
		
		commandFactory command = new commandFactory(commandSet, mathSet, booleanSet, inputCommands);
		System.out.println(command.getCommandList().toString());
		
	}
	
	private static void buildCommandSet(){
		
		//Turtle Commands
		commandSet.add("REPEAT");
		commandSet.add("[");//Indicates
		commandSet.add("FD");//Forward
		commandSet.add("BK");//Back
		commandSet.add("LT");//Left
		commandSet.add("RT");//Right
		commandSet.add("SETH");//Set Heading
		commandSet.add("TOWARDS");
		commandSet.add("SETXY");
		commandSet.add("GOTO");
		commandSet.add("PD");//Pen down
		commandSet.add("PU");//Pen up
		commandSet.add("ST");//Show turtle
		commandSet.add("HT");//Hide turtle
		commandSet.add("HOME");
		commandSet.add("CS");//Clear screen

	}
	
	private static void buildMathSet(){

		//Math Operations
		mathSet.add("SUM");
		mathSet.add("DIFFERENCE");
		mathSet.add("PRODUCT");
		mathSet.add("QUOTIENT");
		mathSet.add("REMAINDER");
		mathSet.add("MINUS");
		mathSet.add("RANDOM");
		mathSet.add("SIN");
		mathSet.add("COS");
		mathSet.add("TAN");
		mathSet.add("ATAN");
		mathSet.add("LOG");
		mathSet.add("POW");
		mathSet.add("PI");
	}
	
	private static void buildBooleanSet(){
		
		//Boolean Operations
		booleanSet.add("LESSP");
		booleanSet.add("GREATERP");
		booleanSet.add("EQUALP");
		booleanSet.add("NOTEQUALP");
		booleanSet.add("AND");
		booleanSet.add("OR");
		booleanSet.add("NOT");
		
	}
}
