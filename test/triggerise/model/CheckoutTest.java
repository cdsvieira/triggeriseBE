package triggerise.model;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

	private Checkout checkout;
	@Before
	public void setup() {
		XforYDiscount discount= new XforYDiscount(2, 1, "TICKET");
		BulkDiscount discount2= new BulkDiscount(3, 1, "HOODIE");
		ArrayList<Discount> pricingRules= new ArrayList<Discount>();
		pricingRules.add(discount);
		pricingRules.add(discount2);
		checkout= new Checkout(pricingRules);
	}
	
	@Test
	public void testScanHoodie() {
		checkout.resetProductsList();
		checkout.scan("HOODIE");
		assert(checkout.getProductList().contains("HOODIE"));
	}
	@Test
	public void testScanHat() {
		checkout.resetProductsList();
		checkout.scan("HAT");
		assert(checkout.getProductList().contains("HAT"));
	}
	@Test
	public void testScanTicket() {
		checkout.resetProductsList();
		checkout.scan("TICKET");
		assert(checkout.getProductList().contains("TICKET"));
	}

	@Test
	public void testTotal1() {
		checkout.resetProductsList();
		String[] items= { "TICKET", "HOODIE", "HAT"};
		double totalExpected= 32.50;
		for(String item:items) {
			checkout.scan(item);
		}
		assert(checkout.total()==totalExpected);
	}
	
	@Test
	public void testTotal2() {
		checkout.resetProductsList();
		String[] items= { "TICKET", "HOODIE", "TICKET"};
		double totalExpected= 25.0;
		for(String item:items) {
			checkout.scan(item);
		}
		assert(checkout.total()==totalExpected);
	}
	
	@Test
	public void testTotal3() {
		checkout.resetProductsList();
		String[] items= { "HOODIE","HOODIE", "HOODIE", "TICKET","HOODIE"};
		double totalExpected= 81.0;
		for(String item:items) {
			checkout.scan(item);
		}
		assert(checkout.total()==totalExpected);
	}
	
	@Test
	public void testTotal4() {
		checkout.resetProductsList();
		String[] items= { "TICKET","HOODIE", "TICKET", "TICKET","HAT","HOODIE","HOODIE"};
		double totalExpected= 74.5;
		for(String item:items) {
			checkout.scan(item);
		}
		assert(checkout.total()==totalExpected);
	}

}
