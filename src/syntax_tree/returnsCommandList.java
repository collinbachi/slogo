package syntax_tree;
import java.util.ArrayList;
import Parser.ParserCommand;
//TODO: Possibly make this an array, and have another "Node" superclass for these to inherit from
public interface returnsCommandList {
	
	ArrayList<ParserCommand> getCommandList();
	
	void appendToCommandList(ParserCommand command);
	
}
