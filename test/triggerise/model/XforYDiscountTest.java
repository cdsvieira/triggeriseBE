package triggerise.model;

import java.util.ArrayList;

import org.junit.Test;

public class XforYDiscountTest {


	@Test
	public void testApplyDiscount2for1Tickets() {
		XforYDiscount discount= new XforYDiscount(2, 1, "TICKET");
		ArrayList<Discount> pricingRules=new ArrayList<>();
		pricingRules.add(discount);
		ProductsList<String> products=new ProductsList<>();
		products.add("TICKET");
		products.add("TICKET");
		double affectance =discount.applyDiscount(products, pricingRules);
		assert(affectance==-5.0);
	}
}
