package syntax_tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class For extends commandState {

	public For(commandFactory arg0, commandFactory arg1, Map<String, returnsValue> variableMap, List<String> inputTokens) {
		//TODO: Wrap loop variables in loop object?
		//Constant VARIABLE = new Constant(Integer.parseInt(arg0.getIndexVariable()));
		String indexVariable = arg0.getIndexVariable();
		ArrayList<String> inputTokensCopy = new ArrayList<String>();
		inputTokensCopy.addAll(inputTokens);
		//TODO:Move order of remove(0) in buildList(FOR)
		final int START     = (int) arg0.getVariableList().get(0).returnValue();
		final int END  	 	= (int) arg0.getVariableList().get(1).returnValue();
		final int INCREMENT = (int) arg0.getVariableList().get(2).returnValue();
		
		for(int i = START; i <= END; i += INCREMENT){
			if(inputTokens.isEmpty()) { inputTokens.addAll(inputTokensCopy); }
			variableMap.put(indexVariable, new Constant(i));
			arg1 = arg1.recurse();
			getCommandList().addAll(arg1.getCommandList());
		}
			
			
		variableMap.remove(arg0.getIndexVariable());

	}
}
