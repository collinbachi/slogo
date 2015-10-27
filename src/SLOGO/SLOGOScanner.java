package SLOGO;

import java.util.Iterator;

public class SLOGOScanner implements Iterable<Token>{
	
	//http://stackoverflow.com/questions/604424/convert-a-string-to-an-enum-in-java
	//http://blog.strongminds.dk/post/2012/11/30/Writing-a-small-parser-interpreter-(Part-1).aspx
	

	private final String rawContents;
	private String[] contents;

	public SLOGOScanner(String input){
		rawContents = input.substring(1, input.length()-1);
		contents = rawContents.split("\\s+");
	}
	
	public Iterator<Token> iterator() {
        return new tokenIterator();
    }
	
	private class tokenIterator implements Iterator<Token>{
		
		private int index;
		
		public tokenIterator(){
			index = 0;
		}

		public boolean hasNext(){
			return index < contents.length;
		}
		
		public Token next(){
			/*if (index==contents.length){
				index++;
			    return Token.fromString("EOF");
			}*/
			String word = contents[index].toUpperCase();
			index++;
			try{
				return Token.fromString(word);
			}catch(IllegalArgumentException e){
				try{
					double d = Double.parseDouble(word);
					return new Token(d);
				}catch(Exception ex){
					return Token.fromSymbol(word);
				}
			}
		
		}
	}

}