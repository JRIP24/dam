package veterinary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisitWithoutDiscountTest {
	
	Visit v1;
	
	@Before
	public void setUp() throws Exception {
		v1 = new VisitWithoutDiscount("13/12/2018", 'M');
	}

	@Test
	public void test() {
		
		v1.setGrossPrice(50);
		assertEquals(60.5, v1.calculateCost(), 0);
	}

}
