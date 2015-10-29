package syntax_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import client.ParserClient;
import parser.ParserCommand;

public class TreeCommandFactory implements returnsCommandList, returnsValue, postCommand {
	private ArrayList<postCommand> commandList = new ArrayList<postCommand>();
	private double value;
	private String currentInput;
	private String indexVariable;

	private Set<String> commandSet;
	private Set<String> mathSet;
	private Set<String> booleanSet;
	private List<String> inputTokens;
	private Map<String, returnsValue> variableMap;
	private Map<String, ArrayList<String>> commandListMap;
	private ParserClient parserClient;

	public TreeCommandFactory(Set<String> commandSet, Set<String> mathSet, Set<String> booleanSet,
			List<String> inputTokens, Map<String, returnsValue> variableMap,
			Map<String, ArrayList<String>> commandListMap, ParserClient parserClient) {
		this.commandSet = commandSet;
		this.mathSet = mathSet;
		this.booleanSet = booleanSet;
		this.inputTokens = inputTokens;
		this.variableMap = variableMap;
		this.commandListMap = commandListMap;
		this.parserClient = parserClient;

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
			while (!toList.isEmpty()) {
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

		case "TELL":
			inputTokens.remove(0); // remove '['
			ArrayList<Integer> actives = new ArrayList<Integer>();
			while(!inputTokens.get(0).equals("RBRACKET")){
				actives.add((int)recurse().returnValue());
			}
			inputTokens.remove(0);
			value = parserClient.setActives(actives);
			break;

		case "REPEAT":
			Repeat newRepeat = new Repeat(parserClient, recurse(), recurse());
			getCommandList().add(newRepeat);
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
			while (!inputTokens.get(index).equals("RBRACKET")) {
				forTokens.add(inputTokens.get(index));
				index++;
			}

			for(int i = 1; i < end; i++){
                for (int j = forTokens.size() - 1; j >= 0; j--) {
                        inputTokens.add(0, forTokens.get(j));
                }
			}

			for (int i = start; i <= end; i++) {
				variableMap.put(indexVariable, new Constant(i));
				TreeCommandFactory newCommandFactory = recurse();
				value = newCommandFactory.returnValue();
				getCommandList().addAll(newCommandFactory.getCommandList());
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
			while (!inputTokens.get(index).equals("RBRACKET")){
				forTokens.add(inputTokens.get(index));
				index++;
			}

			int range = Math.abs(end-start);
			for(int i = 0; i < range; i+= increment){
                for (int j = forTokens.size() - 1; j >= 0; j--) {
                        inputTokens.add(0, forTokens.get(j));
                }
			}

			for (int i = start; i <= end; i += increment) {
				variableMap.put(indexVariable, new Constant(i));
				TreeCommandFactory newCommandFactory = recurse();
				value = newCommandFactory.returnValue();
				getCommandList().addAll(newCommandFactory.getCommandList());
				}

			break;

		case "IF":
			If newIf = new If(parserClient, recurse(), recurse());
			getCommandList().add(newIf);
			break;

		case "IFELSE":
			IfElse newIfElse = new IfElse(parserClient, recurse(), recurse(), recurse());
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
			Forward newForward = new Forward(parserClient, recurse());
			getCommandList().add(newForward);
			break;

		case "BACKWARD":
			Back newBack = new Back(parserClient, recurse());
			getCommandList().addAll(newBack.getCommandList());
			break;

		case "LEFT":
			Left newLeft = new Left(parserClient, recurse());
			getCommandList().add(newLeft);
			break;

		case "RIGHT":
			Right newRight = new Right(parserClient, recurse());
			getCommandList().add(newRight);
			break;

		case "SETHEADING":
			SetHeading newSetHeading = new SetHeading(parserClient, recurse());
			getCommandList().addAll(newSetHeading.getCommandList());
			break;

		case "TOWARDS":
			Towards newTowards = new Towards(parserClient, recurse(), recurse());
			getCommandList().addAll(newTowards.getCommandList());
			break;

		case "SETXY":
			SetXY newSetXY = new SetXY(parserClient, recurse(), recurse());
			getCommandList().addAll(newSetXY.getCommandList());
			break;

		case "PENDOWN":
			PenDown newPenDown = new PenDown(parserClient);
			getCommandList().addAll(newPenDown.getCommandList());
			break;

		case "PENUP":
			PenUp newPenUp = new PenUp(parserClient);
			getCommandList().addAll(newPenUp.getCommandList());
			break;

		case "SHOWTURTLE":
			ShowTurtle newShowTurtle = new ShowTurtle(parserClient);
			getCommandList().addAll(newShowTurtle.getCommandList());
			break;

		case "HIDETURTLE":
			HideTurtle newHideTurtle = new HideTurtle(parserClient);
			getCommandList().addAll(newHideTurtle.getCommandList());
			break;

		case "HOME":
			Home newHome = new Home(parserClient);
			getCommandList().addAll(newHome.getCommandList());
			break;

		case "XCOR?":
			Xcor newXcor = new Xcor(parserClient);
			getCommandList().addAll(newXcor.getCommandList());
			break;

		case "YCOR?":
			Ycor newYcor = new Ycor(parserClient);
			getCommandList().addAll(newYcor.getCommandList());
			break;

		case "HEADING?":
			Heading newHeading = new Heading(parserClient);
			getCommandList().addAll(newHeading.getCommandList());
			break;

		case "PENDOWN?":
			PenDownQuery newPenDownQuery = new PenDownQuery(parserClient);
			getCommandList().addAll(newPenDownQuery.getCommandList());
			break;

		case "SHOWING?":
			Showing newShowing = new Showing(parserClient);
			getCommandList().addAll(newShowing.getCommandList());
			break;

		case "LBRACKET":
			// TODO: Create a list class?
			// buildList(COMMAND);
			while (!inputTokens.get(0).equals("RBRACKET")) {
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
		return new TreeCommandFactory(this.commandSet, this.mathSet, this.booleanSet, this.inputTokens,
				this.variableMap, this.commandListMap, this.parserClient);
	}

	public void resolveVariable(String currentInput) {
		String key = currentInput.substring(1);
		value = variableMap.get(key).returnValue();
	}

	@Override
	public ArrayList<postCommand> getCommandList() {
		return commandList;
	}

	@Override
	public void appendToCommandList(postCommand command) {
		commandList.add(command);
	}

	@Override
	public double returnValue() {
		return value;
	}

	public String getIndexVariable() {
		return indexVariable;
	}

	@Override
	public void postToClient() {
		// TODO Auto-generated method stub
		for (int i = 0; i < getCommandList().size(); i++) {
			getCommandList().get(i).postToClient();
		}

	}
}
