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
	private Map<String, returnsCommandList> commandListMap;

	public TreeCommandFactory(Set<String> commandSet, Set<String> mathSet, Set<String> booleanSet, List<String> inputTokens,
			Map<String, returnsValue> variableMap, Map<String, returnsCommandList> commandListMap, String listType) {
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
			Map<String, returnsValue> variableMap, Map<String, returnsCommandList> commandListMap) {
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
		} else if (commandListMap.containsKey(currentInput)){
			getCommandList().addAll(commandListMap.get(currentInput).getCommandList());
		} else {
			createConstant(currentInput);
		}
	}

	private void createCommand(String currentInput) {
		switch (currentInput) {
		case "REPEAT":
			Repeat newRepeat = new Repeat(recurse(), recurseList(COMMAND));
			getCommandList().addAll(newRepeat.getCommandList());
			break;

		case "DOTIMES":
			DoTimes newDoTimes = new DoTimes(recurseList(DO), this, variableMap, inputTokens);
			getCommandList().addAll(newDoTimes.getCommandList());
			break;

		case "FOR":
			For newFor = new For(recurseList(FOR), this, variableMap, inputTokens);
			getCommandList().addAll(newFor.getCommandList());
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
			recurseList(TO);
			commandListMap.put(commandName, recurse());
			break;

		case "FORWARD":
			Forward newForward = new Forward(recurse());
			getCommandList().addAll(newForward.getCommandList());
			break;
			
		case "BACK":
			Back newBack = new Back(recurse());
			getCommandList().addAll(newBack.getCommandList());
			break;
			
		case "LEFT":
			Left newLeft = new Left(recurse());
			getCommandList().addAll(newLeft.getCommandList());
			break;
			
		case "RIGHT":
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
			buildList(COMMAND);
			break;

		case "MAKE":
			variableMap.put(inputTokens.remove(0), new Constant((int) recurse().returnValue()));
			break;

		// TODO: How will values be "returned"?
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
		if(listType.equals(TO)){ inputTokens.remove(0); }

		if (listType.equals(DO)) {
			inputTokens.remove(0);
			indexVariable = inputTokens.remove(0);
			Constant indexStart = new Constant(1);
			variableMap.put(indexVariable, indexStart);
		}

		if (listType.equals(FOR)) {
			inputTokens.remove(0);
			indexVariable = inputTokens.remove(0);
			Constant indexStart = new Constant((int) recurse().returnValue());
			variableMap.put(indexVariable, indexStart);
			getVariableList().add(indexStart);
		}

		while (!previousToken.equals("LBRACKET") && inputTokens.size() > 0) {
			previousToken = inputTokens.get(0);
			if (listType.equals(COMMAND)) {
				getCommandList().addAll(recurse().getCommandList());
			} else if (listType.equals(TO)) {
				if(previousToken.equals("RBRACKET")) {
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
		// TODO Auto-generated method stub
		return commandList;
	}

	@Override
	public void appendToCommandList(ParserCommand command) {
		// TODO Auto-generated method stub
		commandList.add(command);
	}

	@Override
	public double returnValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public ArrayList<Constant> getVariableList() {
		// TODO Auto-generated method stub
		return variableList;
	}

	@Override
	public void appendToVariableList(Constant c) {
		// TODO Auto-generated method stub

	}

	public String getIndexVariable() {
		return indexVariable;
	}
}
