package triggerise.interfaces;

import java.util.List;

import triggerise.model.Discount;
import triggerise.model.ProductsList;

/**
 * Interface that represents the the behavior of dicountAppliance to a DicountType
 * @author Carlos Vieira
 *
 */
public interface Discountable {

	/**
	 * 
	 * @param listProducts list of products to which the discount will apply
	 * @param listOfPricingRules list of all pricing rules to evaluate and validate constraints
	 * @return the affectance number to the total. 
	 * For example, the affectance number for the 2 tickets(5€ each) in 2-for-1 would be -5
	 */
	public double applyDiscount(ProductsList<String> listProducts,List<? extends Discount> listOfPricingRules);

	
}
