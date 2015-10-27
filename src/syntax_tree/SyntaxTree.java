package syntax_tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import client.ParserClient;
import parser.ParserCommand;

public class SyntaxTree {

	private HashSet<String> commandSet = new HashSet<String>();
	private HashSet<String> mathSet = new HashSet<String>();
	private HashSet<String> booleanSet = new HashSet<String>();
	private ArrayList<String> inputCommands = new ArrayList<String>();
	private ArrayList<ParserCommand> outputCommands = new ArrayList<ParserCommand>();
	private HashMap<String, returnsValue> variableMap = new HashMap<String, returnsValue>();
	private HashMap<String, ArrayList<String>> commandListMap = new HashMap<String, ArrayList<String>>();

	private ParserClient myClient;

	public SyntaxTree(){
		buildCommandSet();
		buildMathSet();
		buildBooleanSet();
	}
	
	public void appendToInput(String input){
		inputCommands.add(input);
	}

	public ArrayList<ParserCommand> parseTokens(ParserClient client){
		myClient = client;
		TreeCommandFactory command = new TreeCommandFactory(commandSet, mathSet, booleanSet, inputCommands, variableMap, commandListMap);
		outputCommands.addAll(command.getCommandList());
		return outputCommands;
	}
	
	
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
		commandSet.add("LBRACKET");// Indicates
		commandSet.add("RBRACKET");// Indicates
		commandSet.add("FORWARD");// Forward
		commandSet.add("BACK");// Back
		commandSet.add("LEFT");// Left
		commandSet.add("RIGHT");// Right
		commandSet.add("SETHEADING");// Set Heading
		commandSet.add("TOWARDS");
		commandSet.add("SETXY");
		commandSet.add("GOTO");
		commandSet.add("PENDOWN");// Pen down
		commandSet.add("PENUP");// Pen up
		commandSet.add("SHOWTURTLE");// Show turtle
		commandSet.add("HIDETURTLE");// Hide turtle
		commandSet.add("HOME");
		commandSet.add("CLEARSCREEN");// Clear screen

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
		booleanSet.add("LESS?");
		booleanSet.add("GREATER?");
		booleanSet.add("EQUAL?");
		booleanSet.add("NOTEQUAL?");
		booleanSet.add("AND");
		booleanSet.add("OR");
		booleanSet.add("NOT");

	}
}
