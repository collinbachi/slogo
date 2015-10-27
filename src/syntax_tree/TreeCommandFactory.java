package syntax_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import parser.ParserCommand;

public class TreeCommandFactory implements returnsCommandList, returnsVariableList, returnsValue {
	private ArrayList<ParserCommand> commandList = new ArrayList<ParserCommand>();
	private ArrayList<Constant> variableList = new ArrayList<Constant>();
	private double value;
	private String currentInput;
	private String indexVariable;

	private final String COMMAND = "commandList";
	private final String VARIABLE = "arrayList";
	private final String FOR = "forList";
	private final String DO = "doList";
	private final String TO = "toList";

	private Set<String> commandSet;
	private Set<String> mathSet;
	private Set<String> booleanSet;
	private List<String> inputTokens;
	private Map<String, returnsValue> variableMap;
	private Map<String, ArrayList<String>> commandListMap;

	public TreeCommandFactory(Set<String> commandSet, Set<String> mathSet, Set<String> booleanSet, List<String> inputTokens,
			Map<String, returnsValue> variableMap, Map<String, ArrayList<String>> commandListMap, String listType) {
		this.commandSet = commandSet;
		this.mathSet = mathSet;
		this.booleanSet = booleanSet;
		this.inputTokens = inputTokens;
		this.variableMap = variableMap;
		this.commandListMap = commandListMap;

		switch (listType) {
		case COMMAND:
			buildList(COMMAND);
			break;
		case VARIABLE:
			buildList(VARIABLE);
			break;
		case FOR:
			buildList(FOR);
			break;
		case DO:
			buildList(DO);
			break;
		case TO:
			buildList(TO);
			break;
		}
	}

	public TreeCommandFactory(Set<String> commandSet, Set<String> mathSet, Set<String> booleanSet, List<String> inputTokens,
			Map<String, returnsValue> variableMap, Map<String, ArrayList<String>> commandListMap) {
		this.commandSet = commandSet;
		this.mathSet = mathSet;
		this.booleanSet = booleanSet;
		this.inputTokens = inputTokens;
		this.variableMap = variableMap;
		this.commandListMap = commandListMap;

		currentInput = inputTokens.remove(0);

		if (commandSet.contains(currentInput)) {
			createCommand(currentInput);
		} else if (mathSet.contains(currentInput)) {
			createMath(currentInput);
		} else if (booleanSet.contains(currentInput)) {
			createBoolean(currentInput);
		} else if (currentInput.charAt(0) == ':') {
			resolveVariable(currentInput);
		} else if (variableMap.containsKey(currentInput)) {
			value = variableMap.get(currentInput).returnValue();
		} else if (commandListMap.containsKey(currentInput)) {
			ArrayList<String> toList = commandListMap.get(currentInput);
			while(!toList.isEmpty()){
				inputTokens.add(0, toList.remove(0));
			}
			recurse();
		} else {
			createConstant(currentInput);
		}
	}

	private void createCommand(String currentInput) {
		String indexVariable;
		int start;
		int end;
		int index;
		ArrayList<String> forTokens;
		switch (currentInput) {
		case "REPEAT":
			Repeat newRepeat = new Repeat(recurse(), recurse());
			getCommandList().addAll(newRepeat.getCommandList());
			break;

		case "DOTIMES":
			inputTokens.remove(0); // Remove '['

			indexVariable = inputTokens.remove(0);
			start = 1;
			end = (int) new Constant((int) recurse().returnValue()).returnValue();

			inputTokens.remove(0);// Remove ']'
			inputTokens.remove(0);// Remove '['

			forTokens = new ArrayList<String>();
			index = 0;
			while (!inputTokens.get(index).equals("]")) {
				forTokens.add(inputTokens.get(index));
				index++;
			}

			for (int i = start; i <= end; i++) {
				variableMap.put(indexVariable, new Constant(i));
				TreeCommandFactory newCommandFactory = recurse();
				value = newCommandFactory.returnValue();
				getCommandList().addAll(newCommandFactory.getCommandList());
				if (i + 1 <= end) {
					for (int j = forTokens.size() - 1; j >= 0; j--) {
						inputTokens.add(0, forTokens.get(j));
					}
				}
			}
			break;

		case "FOR":
			inputTokens.remove(0); // Remove '['

			indexVariable = inputTokens.remove(0);
			start = (int) new Constant((int) recurse().returnValue()).returnValue();
			end = (int) new Constant((int) recurse().returnValue()).returnValue();
			int increment = (int) new Constant((int) recurse().returnValue()).returnValue();

			inputTokens.remove(0);// Remove ']'
			inputTokens.remove(0);// Remove '['

			forTokens = new ArrayList<String>();
			index = 0;
			while (!inputTokens.get(index).equals("]")) {
				forTokens.add(inputTokens.get(index));
				index++;
			}

			for (int i = start; i <= end; i += increment) {
				variableMap.put(indexVariable, new Constant(i));
				TreeCommandFactory newCommandFactory = recurse();
				value = newCommandFactory.returnValue();
				getCommandList().addAll(newCommandFactory.getCommandList());
				if (i + 1 <= end) {
					for (int j = forTokens.size() - 1; j >= 0; j--) {
						inputTokens.add(0, forTokens.get(j));
					}
				}
			}

			break;

		case "IF":
			If newIf = new If(recurse(), recurse());
			getCommandList().addAll(newIf.getCommandList());
			break;

		case "IFELSE":
			IfElse newIfElse = new IfElse(recurse(), recurse(), recurse());
			getCommandList().addAll(newIfElse.getCommandList());
			break;

		case "TO":
			String commandName = inputTokens.remove(0);
			inputTokens.remove(0); // remove '['
			while (!inputTokens.get(0).equals("]")) {
				variableMap.put(inputTokens.remove(0), new Constant(0));
			}
			inputTokens.remove(0); // remove ']'
			inputTokens.remove(0); // remove '['

			ArrayList<String> toCommandList = new ArrayList<String>();
			while (!inputTokens.get(0).equals("]")) {
				toCommandList.add(inputTokens.remove(0));
			}

			commandListMap.put(commandName, toCommandList);
			break;

		case "FORWARD":
			Forward newForward = new Forward(recurse());
			getCommandList().addAll(newForward.getCommandList());
			break;

		case "BK":
			Back newBack = new Back(recurse());
			getCommandList().addAll(newBack.getCommandList());
			break;

		case "LT":
			Left newLeft = new Left(recurse());
			getCommandList().addAll(newLeft.getCommandList());
			break;

		case "RT":
			Right newRight = new Right(recurse());
			getCommandList().addAll(newRight.getCommandList());
			break;

		case "SETHEADING":
			SetHeading newSetHeading = new SetHeading(recurse());
			getCommandList().addAll(newSetHeading.getCommandList());
			break;

		case "TOWARDS":
			Towards newTowards = new Towards(recurse(), recurse());
			getCommandList().addAll(newTowards.getCommandList());
			break;

		case "SETXY":
			SetXY newSetXY = new SetXY(recurse(), recurse());
			getCommandList().addAll(newSetXY.getCommandList());
			break;

		case "PENDOWN":
			PenDown newPenDown = new PenDown();
			getCommandList().addAll(newPenDown.getCommandList());
			break;

		case "PENUP":
			PenUp newPenUp = new PenUp();
			getCommandList().addAll(newPenUp.getCommandList());
			break;

		case "SHOWTURTLE":
			ShowTurtle newShowTurtle = new ShowTurtle();
			getCommandList().addAll(newShowTurtle.getCommandList());
			break;

		case "HIDETURTLE":
			HideTurtle newHideTurtle = new HideTurtle();
			getCommandList().addAll(newHideTurtle.getCommandList());
			break;

		case "HOME":
			Home newHome = new Home();
			getCommandList().addAll(newHome.getCommandList());
			break;

		case "XCOR?":
			Xcor newXcor = new Xcor();
			getCommandList().addAll(newXcor.getCommandList());
			break;

		case "YCOR?":
			Ycor newYcor = new Ycor();
			getCommandList().addAll(newYcor.getCommandList());
			break;

		case "HEADING?":
			Heading newHeading = new Heading();
			getCommandList().addAll(newHeading.getCommandList());
			break;

		case "PENDOWN?":
			PenDownQuery newPenDownQuery = new PenDownQuery();
			getCommandList().addAll(newPenDownQuery.getCommandList());
			break;

		case "SHOWING?":
			Showing newShowing = new Showing();
			getCommandList().addAll(newShowing.getCommandList());
			break;

		case "LBRACKET":
			// TODO: Create a list class?
			// buildList(COMMAND);
			while (!inputTokens.get(0).equals("]")) {
				TreeCommandFactory newCommandFactory = recurse();
				value = newCommandFactory.returnValue();
				getCommandList().addAll(newCommandFactory.getCommandList());
			}
			inputTokens.remove(0);
			break;

		case "MAKE":
			variableMap.put(inputTokens.remove(0), new Constant((int) recurse().returnValue()));
			break;

		case "SET":
			value = variableMap.get(inputTokens.get(0)).returnValue();
			break;

		case "RBRACKET":
			break;
		}
	}

	private void createMath(String currentInput) {
		switch (currentInput) {
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

	}

	private void createBoolean(String currentInput) {
		switch (currentInput) {
		case "LESS?":
			value = new Lessp(recurse(), recurse()).returnValue();
			break;

		case "GREATER?":
			value = new Greaterp(recurse(), recurse()).returnValue();
			break;

		case "EQUAL?":
			value = new Equalp(recurse(), recurse()).returnValue();
			break;

		case "NOTEQUAL?":
			value = new Notequalp(recurse(), recurse()).returnValue();
			break;

		case "AND":
			value = new And(recurse(), recurse()).returnValue();
			break;

		case "OR":
			value = new Lessp(recurse(), recurse()).returnValue();
			break;

		case "NOT":
			value = new Lessp(recurse(), recurse()).returnValue();
			break;
		}
	}

	private void createConstant(String currentInput) {
		System.out.println("give me a break... " + currentInput);
		try {
			int num = Integer.parseInt(currentInput);
			value = new Constant(num).returnValue();
		} catch (NumberFormatException e) {
			System.out.println("Improperly formatted integer, defaulting to 0");
			int num = 0;
			value = new Constant(num).returnValue();
		}
	}

	protected TreeCommandFactory recurse() {
		return new TreeCommandFactory(this.commandSet, this.mathSet, this.booleanSet, this.inputTokens, this.variableMap, this.commandListMap);
	}

	protected TreeCommandFactory recurseList(String listType) {
		return new TreeCommandFactory(this.commandSet, this.mathSet, this.booleanSet, this.inputTokens, this.variableMap, this.commandListMap, listType);
	}

	private void buildList(String listType) {
		String previousToken = inputTokens.get(0);
		if (listType.equals(TO)) {
			inputTokens.remove(0);
		}

		if (listType.equals(DO)) {
			inputTokens.remove(0);
			indexVariable = inputTokens.remove(0);
			Constant indexStart = new Constant(1);
			variableMap.put(indexVariable, indexStart);
		}

		while (!previousToken.equals("LBRACKET") && inputTokens.size() > 0) {
			previousToken = inputTokens.get(0);
			if (listType.equals(COMMAND)) {
				getCommandList().addAll(recurse().getCommandList());
			} else if (listType.equals(TO)) {
				if (previousToken.equals("]")) {
					inputTokens.remove(0);
					return;
				}
				variableMap.put(inputTokens.remove(0), new Constant((int) recurse().returnValue()));
			} else {
				getVariableList().add(new Constant((int) recurse().returnValue()));
			}
		}
	}

	public void resolveVariable(String currentInput) {
		String key = currentInput.substring(1);
		value = variableMap.get(key).returnValue();
	}

	@Override
	public ArrayList<ParserCommand> getCommandList() {
		return commandList;
	}

	@Override
	public void appendToCommandList(ParserCommand command) {
		commandList.add(command);
	}

	@Override
	public double returnValue() {
		return value;
	}

	@Override
	public ArrayList<Constant> getVariableList() {
		return variableList;
	}

	@Override
	public void appendToVariableList(Constant c) {}

	public String getIndexVariable() {
		return indexVariable;
	}
}
