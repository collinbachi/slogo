package SLOGO;

import java.util.ArrayList;
import java.util.Arrays;

public class SLOGOScanner {
	
	//http://stackoverflow.com/questions/604424/convert-a-string-to-an-enum-in-java
	//http://blog.strongminds.dk/post/2012/11/30/Writing-a-small-parser-interpreter-(Part-1).aspx
	public enum Token {
		REPEAT("REPEAT"),
		FD("FD"),
		BK("BK"),
		LT("LT"),
		RT("RT"),
		CONSTANT("CONSTANT"),
		VARIABLE("VARIABLE"),
		LBRACKET("["),
		RBRACKET("]"),
		SETHEADING("SETHEADING"),
		TOWARDS("TOWARDS"),
		SETXY("SETXY"),
		PENDOWN("PENDOWN"),
		PENUP("PENUP"),
		SHOWTURTLE("SHOWTURTLE"),
		HIDETURTLE("HIDETURTLE"),
		HOME("HOME"),
		CLEARSCREEN("CLEARSCREEN"),
		XCOR("XCOR"),
		YCOR("YCOR"),
		PENDOWNQ("PENDOWN?"),
		SHOWINGQ("SHOWING?"),
		SUM("SUM"),
		DIFFERENCE("DIFFERENCE"),
		PRODUCT("PRODUCT"),
		QUOTIENT("QUOTIENT"),
		REMAINDER("REMAINDER"),
		MINUS("MINUS"),
		RANDOM("RANDOM"),
		SIN("SIN"),
		COS("COS"),
		TAN("TAN"),
		ATAN("ATAN"),
		LOG("LOG"),
		POW("POW"),
		PI("PI"),
		LESSP("LESS?"),
		GREATERP("GREATER?"),
		EQUALP("EQUAL?"),
		NOTEQUALP("NOTEQUAL?"),
		AND("AND"),
		OR("OR"),
		NOT("NOT"),
		MAKE("MAKE"),
		DOTIMES("DOTIMES"),
		FOR("FOR"),
		IF("IF"),
		IFELSE("IFELSE"),
		TO("TO"),
		EOF;

		private String text;

		Token(String text) {
			this.text = text;
		}

		Token(){
			  //do nothing
		}

		public String getText() {
			return this.text;
		}

	}

	private final String rawContents;
	private String scanBuffer;
	private int index;
	private char ch;
	private Token input;
	private ArrayList<String> splitBySpaces;

	public SLOGOScanner(String input){
		String temp = input.substring(1);
		String removeBrackets = temp.substring(0, temp.length()-1);
		rawContents = removeBrackets;
		splitBySpaces = new ArrayList<String>(Arrays.asList(rawContents.split(" ")));
	}

	public String next(){

		return fromString(splitBySpaces.remove(0)).toString();
	}
	
	public boolean hasNext(){
		return !splitBySpaces.isEmpty();
	}

   private String fromString(String text) {
	   if (text != null) {
		   for (Token b : Token.values()) {
			   if (text.equalsIgnoreCase(b.text)) {
				   if(b.equals(Token.LBRACKET) || b.equals(Token.RBRACKET)){
					   return text;
				   }
				   return b.toString();
               }
           }
		   return text;
       }else{
    	   return null;
       }
	   //throw new IllegalArgumentException("No constant with text " + text + " found");
   }

}