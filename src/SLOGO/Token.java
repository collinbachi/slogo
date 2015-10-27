package SLOGO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;

public class Token {
	
	private Tkn value;
	private double numValue;
	private String strValue;
	
	private static HashMap<String, String> aliases = new HashMap<String, String>();
	static{ aliases.put("RBRACKET", "]");
			aliases.put("LBRACKET", "[");
			aliases.put("FD", "FORWARD");
			aliases.put("BK", "BACK");
			aliases.put("LT", "LEFT");
			aliases.put("RT", "RIGHT");
			aliases.put("SETH", "SETHEADING");
			aliases.put("GOTO", "SETXY");
			aliases.put("PD", "PENDOWN");
			aliases.put("PU", "PENUP");
			aliases.put("ST", "SHOWTURTLE");
			aliases.put("HT", "HIDETURTLE");
			aliases.put("CS", "CLEARSCREEN");
			aliases.put("PENDOWNP", "PENDOWN?");
			aliases.put("SHOWINGP", "SHOWING?");
			aliases.put("+", "SUM");
			aliases.put("-", "DIFFERENCE");
			aliases.put("*", "PRODUCT");
			aliases.put("/", "QUOTIENT");
			aliases.put("%", "REMAINDER");
			aliases.put("~", "MINUS");
			aliases.put("LESSP", "LESS?");
			aliases.put("GREATERP", "GREATER?");
			aliases.put("EQUALP", "EQUAL?");
			aliases.put("NOTEQUALP", "NOTEQUAL?");
			aliases.put("SET", "MAKE");

			try {
				File[] files = new File("resources/languages").listFiles();
				for (File f : files) System.out.println(f.toString());
				for (File f : files){
	
						for (String line : Files.readAllLines(f.toPath())) {
							if (line.charAt(0)=='#') continue;
							String [] parts = line.split("=");
							parts[0] = parts[0].trim().toUpperCase();
							parts[1] = parts[1].trim();
							if (!parts[1].contains("|")){ aliases.put(parts[1], parts[0]);
							}else{ String[] subparts = parts[1].split("\\|");
								aliases.put(subparts[0].toUpperCase(), parts[0]);
								aliases.put(subparts[1].toUpperCase(),  parts[0]);
								//System.out.println(subparts[0] + " and " + subparts[1] + " of " + parts[1]);
							}
						}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public Token(Tkn t){
		this.value = t;
	}
	
	public Token(Double d){
		this.value = Tkn.NUMBER;
		this.numValue = d;
	}
	
	public int getNumber(){ return (int)numValue; }
	
	public String getString(){ return strValue; }
	
	public Token(String s){
		if(aliases.containsKey(s.toUpperCase())){
			//System.out.println(">>" + s + "  " + aliases.get(s));
			s=aliases.get(s);
		}
		//System.out.println(aliases.get("ZZ"));
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
		return new Token(text);
	}
	
	public static Token fromSymbol(String text) {
		return new Token(Tkn.SYMBOL, text);
	}
	
	public Token(Tkn t, String s){
		this.strValue = s;
		this.value = t;
	}
	
	public enum Tkn {
			REPEAT("REPEAT"),
			FORWARD("FORWARD"),
			BACK("BACK"),
			LEFT("LEFT"),
			RIGHT("RIGHT"),
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
			SYMBOL("SYMBOL"),
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
				//if(aliases.containsKey(text)) text=aliases.get(text);
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