package triggerise.model;

import java.util.List;

import triggerise.utils.Catalog;

/**
 * Represents a type of discount where if you buy a certain amount, a part is free
 * For example: 2-for-1 discount: if you buy 2, 1 is free
 * @author Carlos Vieira
 *
 */
public class XforYDiscount extends Discount {

	
	
	/**
	 * THe factor y (free part) of the XforYDiscount. For example: in 2-for-1 discount, y would
	 * be 1
	 */
	private int y;

	/**
	 * The factor x (bought amount) of the XforYDiscount. For example: in 2-for-1 discount, x would
	 * be 2
	 */
	private int x;

	/**
	 * COnstructor for a valid XforYDiscount with
	 * @param x amount that needs to be bought to get y free
	 * @param y the free part got if x amount is bought
	 * @param discountedItem the item that this discount concerns
	 */
	public XforYDiscount(int x, int y,String discountedItem) {
		super(discountedItem);
		this.x = x;
		this.y = y;
		
	}

	@Override
	public double applyDiscount(ProductsList<String> listProducts, List<? extends Discount> listOfPricingRules) {
		double affectance= 0;
		if (!validate(listProducts,listOfPricingRules)) {
			return affectance;
		}
		int itemAmount= listProducts.getCount(discountedItem);
		int timesToDiscount= itemAmount/x;//times to apply the discount
		affectance = timesToDiscount*y * Catalog.getPrice(discountedItem)*-1;
		return affectance;		
	}

}
