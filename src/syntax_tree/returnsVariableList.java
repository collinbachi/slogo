package syntax_tree;
import java.util.ArrayList;

public interface returnsVariableList {
	
	ArrayList<Constant> getVariableList();
	
	void appendToVariableList (Constant c); 

}
