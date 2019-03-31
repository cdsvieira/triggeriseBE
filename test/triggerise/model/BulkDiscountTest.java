package triggerise.model;

import java.util.ArrayList;

import org.junit.Test;

public class BulkDiscountTest {

	
	
	@Test
	public void testApplyDiscountMoreThan3Hoodies() {
		BulkDiscount discount= new BulkDiscount(3, 1, "HOODIE");
		ArrayList<Discount> pricingRules=new ArrayList<>();
		pricingRules.add(discount);
		ProductsList<String> products=new ProductsList<>();
		products.add("HOODIE");
		products.add("HOODIE");
		products.add("HOODIE");
		double affectance =discount.applyDiscount(products, pricingRules);
		assert(affectance==-3.0);
	}
	
	@Test
	public void testApplyDiscountMoreThan3Hoodies_2() {
		BulkDiscount discount= new BulkDiscount(3, 1, "HOODIE");
		ArrayList<Discount> pricingRules=new ArrayList<>();
		pricingRules.add(discount);
		ProductsList<String> products=new ProductsList<>();
		products.add("HOODIE");
		products.add("HOODIE");
		products.add("HOODIE");
		products.add("HOODIE");
		double affectance =discount.applyDiscount(products, pricingRules);
		assert(affectance==-4.0);
	}
	
	@Test
	public void testApplyDiscountMoreThan2Hats() {
		int discountPerItem=1;
		int bulkAmount=2;
		BulkDiscount discount= new BulkDiscount(bulkAmount, discountPerItem, "HAT");
		ArrayList<Discount> pricingRules=new ArrayList<>();
		pricingRules.add(discount);
		ProductsList<String> products=new ProductsList<>();
		products.add("HAT");
		products.add("HAT");
		products.add("HAT");
		double affectance =discount.applyDiscount(products, pricingRules);
		assert(affectance==-3.0);
	}
	
	
}
