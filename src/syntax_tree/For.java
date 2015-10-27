package syntax_tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class For extends commandState {

	public For(returnsCommandList commandFactory, Map<String, returnsValue> variableMap, List<String> inputTokens, String indexVariable,
				returnsValue start, returnsValue end, returnsValue increment){
		//TODO:Move order of remove(0) in buildList(FOR)
		final int START     = (int) start.returnValue();
		final int END  	 	= (int) end.returnValue();
		final int INCREMENT = (int) increment.returnValue();
		ArrayList<String> forTokens = new ArrayList<String>();
		
		inputTokens.remove(0); //remove '['
		int index = 0; 
		while(!inputTokens.get(index).equals("]")){
			forTokens.add(inputTokens.get(index));
		}
		
		for(int i = START; i <= END; i += INCREMENT){
			inputTokens.add(0, forTokens.get(i));
		}
		
		for(int i = START; i <= END; i += INCREMENT){
			//if(inputTokens.isEmpty()) { inputTokens.addAll(inputTokensCopy); }
			variableMap.put(indexVariable, new Constant(i));
			getCommandList().addAll(commandFactory.recurse().getCommandList());
		}
			
		variableMap.remove(arg0.getIndexVariable());

	}
}
