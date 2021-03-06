package triggerise.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This is just a class to hold the catalog informations. 
 * TODO: pass to config or db
 * @author Carlos Vieira
 *
 */
public class Catalog {

	/**
	 * temporary static catalog for exercise sake
	 */
	 private static Map<String, Double> catalog;

	 /**
	  * retrieves the price of a certain item
	  * @param item
	  * @return
	  */
	 public static double getPrice(String item) {
		 Map<String, Double> catalog= new HashMap<>(3);
	        catalog.put("HOODIE",20.0);
	        catalog.put("TICKET",5.0);
	        catalog.put("HAT",7.5);
		 return catalog.get(item);
	 }
	    
}
