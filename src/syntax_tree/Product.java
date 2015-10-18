package syntax_tree;

public class Product extends valueState {
	
	public Product(returnsValue arg0, returnsValue arg1){
		value = arg0.returnValue() * arg1.returnValue();
	}

}
