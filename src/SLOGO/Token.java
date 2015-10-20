package SLOGO;

public class Token {
	
	private Tkn value;
	private double numValue;
	
	public Token(Tkn t){
		this.value = t;
	}
	
	public Token(Double d){
		this.value = Tkn.NUMBER;
		this.numValue = d;
	}
	
	public Token(String s){
		this.value = Tkn.fromString(s);
	}
	
	public boolean equals(Object object2) {
	    return object2 instanceof Token && value.equals(((Token)object2).value);
	}
	
	public int hashCode(){
		return value.hashCode();
	}
	
	public String toString(){
		return value.toString();
	}

	
	public static Token fromString(String text) {
			return new Token(Tkn.fromString(text));
	}
	
	public enum Tkn {
			REPEAT("REPEAT"),
			FORWARD("FORWARD"),
			BACK("BACK"),
			LEFT("LEFT"),
			RIGHT("RIGHT"),
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
			NUMBER("NUMBER"),
			EOF("EOF");
	
			private String text;
	
			Tkn(String text) {
				this.text = text;
			}
	
			Tkn(){
				  //do nothing
			}
	
			public String getText() {
				return this.text;
			}
	
			public static Tkn fromString(String text) {
				if (text != null) {
					for (Tkn b : Tkn.values()) {
						if (text.equalsIgnoreCase(b.text)) {
							return b;
						}
					}
				}
				throw new IllegalArgumentException("No constant with text " + text + " found");
			}
		}
}