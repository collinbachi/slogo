import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {
	private List<String> line;
	private Node tree;
	
	public TreeBuilder(ArrayList<String> line){
		this.line = line;
		buildTree();
	}
	
	private void buildTree(){
		if(line.get(0).equals(SLOGOScanner.Token.FORWARD)){
			//tree = new CommandNode(null, SLOGOScanner.Token.FORWARD);
		}
		
		
	}
	
	private Node makeNode(Node prev, String next){
		if(next.equals(SLOGOScanner.Token.FORWARD)){
			//return new CommandNode(prev, SLOGOScanner.Token.FORWARD);
		}
		return null;
	}
}
