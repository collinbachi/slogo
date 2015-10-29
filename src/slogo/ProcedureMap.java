package slogo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import parser.ParserCommand;


public class ProcedureMap {
	private Map<String, ArrayList<ParserCommand>> pmap;
	
	public ProcedureMap(){
		pmap = new HashMap<String, ArrayList<ParserCommand>>();
	}
	
	public ArrayList<ParserCommand> getProcedure(String key){
		if(pmap.containsKey(key)){
			return pmap.get(key);
		}
		
		return new ArrayList<ParserCommand>();
	}
	
	public void setProcedure(String key, ArrayList<ParserCommand> commands){
		pmap.put(key, commands);
	}
}
