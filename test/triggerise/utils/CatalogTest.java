package triggerise.utils;

import org.junit.Test;

public class CatalogTest {

	@Test
	public void testCatalogHoodie() {
		double expected = 20.0;
		double actual = Catalog.getPrice("HOODIE");
		assert(expected == actual);
	}

	@Test
	public void testCatalogTicket() {
		double expected = 5.0;
		assert(expected == Catalog.getPrice("TICKET"));
	}

	@Test
	public void testCatalogHat() {
		double expected = 7.5;
		assert(expected == Catalog.getPrice("HAT"));
	}

}
