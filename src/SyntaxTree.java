import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SyntaxTree {

	private static HashSet<String> commandSet = new HashSet<String>();
	private static HashSet<String> mathSet = new HashSet<String>();
	private static HashSet<String> booleanSet = new HashSet<String>();

	public static void main(String[] args) {
		buildCommandSet();
		buildMathSet();
		buildBooleanSet();

		HashMap<String, returnsValue> variableMap = new HashMap<String, returnsValue>();
		ArrayList<String> inputCommands = new ArrayList<String>();
		ArrayList<String> outputCommands = new ArrayList<String>();

		inputCommands.add("MAKE");
		inputCommands.add("VAR");
		inputCommands.add("3");
		inputCommands.add("FOR");
		inputCommands.add("[");
		inputCommands.add("INDEX");
		inputCommands.add("1");
		inputCommands.add("1");
		inputCommands.add("1");
		inputCommands.add("]");
		inputCommands.add("[");
		inputCommands.add("FD");
		inputCommands.add("INDEX");
		inputCommands.add("FD");
		inputCommands.add("VAR");
		inputCommands.add("]");

		// inputCommands.add("IFELSE");
		// inputCommands.add("GREATERP");
		// inputCommands.add("3");
		// inputCommands.add("1");
		// inputCommands.add("[");
		// inputCommands.add("FD");
		// inputCommands.add("2");
		// inputCommands.add("FD");
		// inputCommands.add("3");
		// inputCommands.add("]");
		// inputCommands.add("[");
		// inputCommands.add("FD");
		// inputCommands.add("1");
		// inputCommands.add("FD");
		// inputCommands.add("3");
		// inputCommands.add("]");

		// inputCommands.add("REPEAT");
		//// inputCommands.add("3");
		// inputCommands.add("PRODUCT");
		// inputCommands.add("4");
		// inputCommands.add("2");
		// inputCommands.add("[");
		// inputCommands.add("FD");
		// inputCommands.add("2");
		// inputCommands.add("]");

		while (!inputCommands.isEmpty()) {
			commandFactory command = new commandFactory(commandSet, mathSet, booleanSet, inputCommands, variableMap);
			outputCommands.addAll(command.getCommandList());
		}
		System.out.println(outputCommands.toString());

	}

	private static void buildCommandSet() {

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

	private static void buildMathSet() {

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

	private static void buildBooleanSet() {

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
