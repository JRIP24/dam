package veterinary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisitWithDiscountTest {
	
	Visit v1;
	Visit v2;

	@Test
	public void testSummer() {
		v1 = new VisitWithDiscount("13/08/2018", 'M');
		v1.setGrossPrice(60);
		assertEquals(61.71, v1.calculateCost(), 0);
		
	}
	
	@Test
	public void testSummer2() {
		v1 = new VisitWithDiscount("13/07/2018", 'M');
		v1.setGrossPrice(50);
		assertEquals(51.425, v1.calculateCost(), 0);
		
	}
	
	
	@Test
	public void testNOTSummer() {
		v2 = new VisitWithDiscount("13/12/2018", 'M');
		v2.setGrossPrice(50);
		assertEquals(54.45, v2.calculateCost(), 0);
		
	}

}
