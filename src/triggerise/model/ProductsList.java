package triggerise.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the list of products to a generic type in case we want to
 * progress our String list to an actual product model list
 * @author Carlos Vieira
 *
 * @param <E>
 */
public class ProductsList<E> extends ArrayList<E> {

	
	
	/**
	 * our list of products that consists of a map with the product and its amount 
	 * in the list
	 */
    private Map<E,Integer> listOfProducts = new HashMap<E,Integer>();

    
    /**
     * adds a product to our product list with a counter so we can use that
     * to calculate discounts and total at checkout
     */
    public boolean add( E element  ) { 
        if( !listOfProducts.containsKey( element ) ){
            listOfProducts.put( element, 1 );
        } else { 
            listOfProducts.put( element, listOfProducts.get( element ) + 1 );
        }
        return super.add( element );
    }


    /**
     * Returns the counter for a given key
     * @param element
     * @return the counter for this products
     */
    public int getCount( E element ) { 
        if( ! listOfProducts.containsKey( element ) ) {
            return 0;
        }
        return listOfProducts.get( element );
    }

}
