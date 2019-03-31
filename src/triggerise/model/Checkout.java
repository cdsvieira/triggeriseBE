package triggerise.model;

import java.util.List;

import triggerise.interfaces.Checkoutable;
import triggerise.utils.Catalog;


/**
 * Represents an instaciable Checkout, representing the checkout of a list of products
 * @author Carlos Vieira
 *
 */
public class Checkout implements Checkoutable{

	/**
	 * Represents the list of products being scanned in the checkout
	 */
	private ProductsList<String> listOfProducts;
		
	/**
	 * Represents a list of pricing rules to account for in this checkout
	 */
	private List<Discount> pricingRules;
	
	/**
	 * Creates a valid Checkout with the pricing rules to account for
	 * @param pricingRules
	 */
	public Checkout(List<Discount> pricingRules) {
		this.pricingRules=pricingRules;
		listOfProducts= new ProductsList<String>();
	}
	
	@Override
	public void scan(String item) {
		if(validateItem(item)) {
			listOfProducts.add(item);
		}else {
			//TODO throw custom exception/log error/business logic
		}
		
	}
	
	public ProductsList<String> getProductList() {
		return this.listOfProducts;
	}
	
	/**
	 * Resets all the products in checkout
	 */
	public void resetProductsList() {
		this.listOfProducts= new ProductsList<String>();
	}

	/**
	 * returns the total result of the list of products with the discounts applied
	 */
	public double total() {
		double totalAffectance=0;
		for(Discount pricingRule:pricingRules) {
			totalAffectance =totalAffectance+ pricingRule.applyDiscount(listOfProducts, pricingRules);
		}
		double total=0;
		for(String product:listOfProducts) {
			total =total+ Catalog.getPrice(product);
		}
		return total + totalAffectance;
	}
	
	/**
	 * Validates an item.
	 * For example, verifies if the item is in stock or in the catalog
	 * @param item
	 * @return
	 */
	private boolean validateItem(String item) {
		//TODO implement business logic to validate if an item is in stock/catalog
		return true;
	}
	
	
}
