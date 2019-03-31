package triggerise.model;

import java.util.List;

/**
 * Represents a type of discount where if you buy a certain amount it makes a discount per item
 * @author Carlos Vieira
 *
 */
public class BulkDiscount extends Discount{

	/**
	 * The amount where you will provide the discount from
	 */
	private int bulkAmount;
	
	/**
	 * The discount per item in case the ammount is more than the bulkAmount
	 */
	private int itemDiscount;
	
	/**
	 * Creates a valid BulkDiscount with
	 * @param bulkAmount the amount of a certain item that need to be bought to apply discount
	 * @param itemDiscount the discount per item in case it is a bulk buy
	 * @param discountedItem the item that represents the discount
	 */
	public BulkDiscount(int bulkAmount, int itemDiscount, String discountedItem) {
		super(discountedItem);
		this.bulkAmount=bulkAmount;
		this.itemDiscount=itemDiscount;
	}
	
	
	@Override
	public double applyDiscount(ProductsList<String> listProducts, List<? extends Discount> listOfPricingRules) {
		double affectance=0;
		if (!validate(listProducts,listOfPricingRules)) {
			return 0;
		}
		int itemAmount= listProducts.getCount(discountedItem);
		if(itemAmount>=this.bulkAmount) {
			affectance= itemAmount*itemDiscount*-1;
		}
		return affectance;
	}
	
	@Override
	protected boolean validate(ProductsList<String> listProducts,List<? extends Discount> listOfpricingRules) {
		//TODO : validate if there is a discount with a bigger discount for this item and for a larger 
		//For example: if there is a discount of 1 euro for bulk buy 3 hoodies, 
		//and then a discount of 2 euros for bulk buy 5 hoodies,don't count the first if the ammount is 5 hoodies
		return true;
	}
	
	

}
