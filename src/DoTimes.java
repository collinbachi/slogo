import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoTimes extends commandState {

	public DoTimes(commandFactory arg0, commandFactory arg1, Map<String, returnsValue> variableMap,
			List<String> inputTokens) {
		String indexVariable = arg0.getIndexVariable();
		ArrayList<String> inputTokensCopy = new ArrayList<String>();
		inputTokensCopy.addAll(inputTokens);
		final int END = (int) arg0.getVariableList().get(0).returnValue();

		for (int i = 1; i <= END; i++) {
			if (inputTokens.isEmpty()) {
				inputTokens.addAll(inputTokensCopy);
			}
			variableMap.put(indexVariable, new Constant(i));
			arg1 = arg1.recurse();
			getCommandList().addAll(arg1.getCommandList());
		}
	}
}
