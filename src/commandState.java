import java.util.ArrayList;

public class commandState {
	ArrayList<String> commandList = new ArrayList<String>();
	
	public commandState(){
		
	}
	
	protected ArrayList<String> getCommandList(){
		return commandList;
	}
	
	protected void appendToCommandList(String s){
		commandList.add(s);
	}
	

}
