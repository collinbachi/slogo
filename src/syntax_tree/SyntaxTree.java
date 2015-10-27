package syntax_tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import parser.ParserCommand;

public class SyntaxTree {

	private HashSet<String> commandSet = new HashSet<String>();
	private HashSet<String> mathSet = new HashSet<String>();
	private HashSet<String> booleanSet = new HashSet<String>();
	private ArrayList<String> inputCommands = new ArrayList<String>();
	private ArrayList<ParserCommand> outputCommands = new ArrayList<ParserCommand>();
	private HashMap<String, returnsValue> variableMap = new HashMap<String, returnsValue>();
	private HashMap<String, returnsCommandList> commandListMap = new HashMap<String, returnsCommandList>();

	public SyntaxTree(){
		buildCommandSet();
		buildMathSet();
		buildBooleanSet();
	}
	
	public void appendToInput(String input){
		inputCommands.add(input);
	}

	public ArrayList<ParserCommand> parseTokens(){
		commandFactory command = new commandFactory(commandSet, mathSet, booleanSet, inputCommands, variableMap, commandListMap);
		outputCommands.addAll(command.getCommandList());
		//System.out.println(outputCommands.toString());
		return outputCommands;
	}
	
	//public static void main(String[] args) {
	//	buildCommandSet();
	//	buildMathSet();
	//	buildBooleanSet();

	//	HashMap<String, returnsValue> variableMap = new HashMap<String, returnsValue>();
	//	HashMap<String, returnsCommandList> commandListMap = new HashMap<String, returnsCommandList>();
	//	ArrayList<String> inputCommands = new ArrayList<String>();
	//	ArrayList<String> outputCommands = new ArrayList<String>();
	//	
	//	inputCommands.add("TO");
	//	inputCommands.add("commandVar");
	//	inputCommands.add("[");
	//	inputCommands.add("A");
	//	inputCommands.add("1");
	//	inputCommands.add("B");
	//	inputCommands.add("4");
	//	inputCommands.add("]");
	//	inputCommands.add("[");
	//	inputCommands.add("FD");
	//	inputCommands.add("SUM");
	//	inputCommands.add("A");
	//	inputCommands.add("B");
	//	inputCommands.add("]");
	//	inputCommands.add("commandVar");

	//	//inputCommands.add("DOTIMES");
	//	//inputCommands.add("[");
	//	//inputCommands.add("INDEX");
	//	//inputCommands.add("6");
	//	//inputCommands.add("]");
	//	//inputCommands.add("[");
	//	//inputCommands.add("FD");
	//	//inputCommands.add("INDEX");
	//	//inputCommands.add("]");

	//	//inputCommands.add("MAKE");
	//	//inputCommands.add("VAR");
	//	//inputCommands.add("3");
	//	//inputCommands.add("FOR");
	//	//inputCommands.add("[");
	//	//inputCommands.add("INDEX");
	//	//inputCommands.add("1");
	//	//inputCommands.add("1");
	//	//inputCommands.add("1");
	//	//inputCommands.add("]");
	//	//inputCommands.add("[");
	//	//inputCommands.add("FD");
	//	//inputCommands.add("INDEX");
	//	//inputCommands.add("FD");
	//	//inputCommands.add("VAR");
	//	//inputCommands.add("]");

	//	// inputCommands.add("IFELSE");
	//	// inputCommands.add("GREATERP");
	//	// inputCommands.add("3");
	//	// inputCommands.add("1");
	//	// inputCommands.add("[");
	//	// inputCommands.add("FD");
	//	// inputCommands.add("2");
	//	// inputCommands.add("FD");
	//	// inputCommands.add("3");
	//	// inputCommands.add("]");
	//	// inputCommands.add("[");
	//	// inputCommands.add("FD");
	//	// inputCommands.add("1");
	//	// inputCommands.add("FD");
	//	// inputCommands.add("3");
	//	// inputCommands.add("]");

	//	// inputCommands.add("REPEAT");
	//	//// inputCommands.add("3");
	//	// inputCommands.add("PRODUCT");
	//	// inputCommands.add("4");
	//	// inputCommands.add("2");
	//	// inputCommands.add("[");
	//	// inputCommands.add("FD");
	//	// inputCommands.add("2");
	//	// inputCommands.add("]");

	//	while (!inputCommands.isEmpty()) {
	//		commandFactory command = new commandFactory(commandSet, mathSet, booleanSet, inputCommands, variableMap, commandListMap);
	//		outputCommands.addAll(command.getCommandList());
	//	}
	//	System.out.println(outputCommands.toString());

	//}

	private void buildCommandSet() {

		// Turtle Commands
		commandSet.add("REPEAT");
		commandSet.add("IF");
		commandSet.add("IFELSE");
		commandSet.add("FOR");
		commandSet.add("TO");
		commandSet.add("DOTIMES");
		commandSet.add("MAKE");
		commandSet.add("SET");
		commandSet.add("[");// Indicates
		commandSet.add("]");// Indicates
		commandSet.add("FD");// Forward
		commandSet.add("BK");// Back
		commandSet.add("LT");// Left
		commandSet.add("RT");// Right
		commandSet.add("SETH");// Set Heading
		commandSet.add("TOWARDS");
		commandSet.add("SETXY");
		commandSet.add("GOTO");
		commandSet.add("PD");// Pen down
		commandSet.add("PU");// Pen up
		commandSet.add("ST");// Show turtle
		commandSet.add("HT");// Hide turtle
		commandSet.add("HOME");
		commandSet.add("CS");// Clear screen

	}

	private void buildMathSet() {

		// Math Operations
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

	private void buildBooleanSet() {

		// Boolean Operations
		booleanSet.add("LESSP");
		booleanSet.add("GREATERP");
		booleanSet.add("EQUALP");
		booleanSet.add("NOTEQUALP");
		booleanSet.add("AND");
		booleanSet.add("OR");
		booleanSet.add("NOT");

	}
}
