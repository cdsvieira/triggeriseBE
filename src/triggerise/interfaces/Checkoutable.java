package triggerise.interfaces;

import java.util.List;

/**
 * Interface that meets the requirements' interface. 
 * It represents the behavior of a Checkout class/singleton
 * @author Carlos Vieira
 *
 */
public interface Checkoutable {

		
	/**
	 * Proceeds to scan an item to include them in the list of products
	 * @param item
	 */
	public void scan(String item);
	
	/**
	 * Calculates the total of the list of products' checkout
	 */
	public double total();
}
