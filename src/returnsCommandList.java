import java.util.ArrayList;
//TODO: Possibly make this an array, and have another "Node" superclass for these to inherit from
public interface returnsCommandList {
	
	ArrayList<String> getCommandList();
	
	void appendToCommandList(String s);
	
}
