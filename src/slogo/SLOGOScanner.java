package slogo;

import java.util.Iterator;

public class SLOGOScanner implements Iterable<Token>{
	
	// Referenced the following during early development:
	// http://stackoverflow.com/questions/604424/convert-a-string-to-an-enum-in-java
	// http://blog.strongminds.dk/post/2012/11/30/Writing-a-small-parser-interpreter-(Part-1).aspx
	

	private final String rawContents;
	private String[] contents;

	public SLOGOScanner(String input){
		rawContents = input;
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