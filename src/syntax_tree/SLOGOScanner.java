package syntax_tree;


public class SLOGOScanner {
	
	//http://stackoverflow.com/questions/604424/convert-a-string-to-an-enum-in-java
	public enum Token {
		REPEAT("REPEAT"),
		FORWARD("FORWARD"),
		BACK("BACK"),
		LEFT("LEFT"),
		RIGHT("RIGHT"),
		CONSTANT("CONSTANT"),
		LBRACKET("["),
		RBRACKET("]"),
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

		public static Token fromString(String text) {
			if (text != null) {
				for (Token b : Token.values()) {
					if (text.equalsIgnoreCase(b.text)) {
						return b;
					}
				}
			}
			throw new IllegalArgumentException("No constant with text " + text + " found");
		}
	}

}
