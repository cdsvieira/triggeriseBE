package triggerise.model;

import java.util.List;

import triggerise.interfaces.Discountable;

/**
 * Super class of a type of pricingRule that is the Discount.
 * Each Discount subtype, it's responsible for calculating the affectance of the total
 * @author Carlos Vieira
 *
 */
public abstract class Discount implements Discountable{

	/**
	 * The item to which discount applies to
	 */
	protected String discountedItem;
	
	public Discount(String discountedItem) {
		this.discountedItem=discountedItem;
	}
	
	/**
	 * Responsible for validating constraints between discounts. 
	 * Normally, evolutions in business rules would be written in Discounts subtype
	 * and this method would be overwritten
	 */
	protected boolean validate(ProductsList<String> listProducts,List<? extends Discount> listOfPricingRules) {
		//TODO override this method and implement the business constraints between the discounts
		return true;
	}
	
}
