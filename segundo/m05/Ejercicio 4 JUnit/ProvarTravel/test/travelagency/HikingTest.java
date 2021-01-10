package travelagency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HikingTest {

    private static Trip t1;
    private static Person a1;
    private static Group g1;

    @BeforeEach
    void setUp() {
        t1 = new Hiking("Passejant pel Montseny", 5, "10/06/2012", "10/06/2012", 30);
        a1 = new Adult("11", "Joan Grau");
        g1 = new Group();
    }

    @Test
    public void testPriceMes() {
        g1.add(a1);
        t1.add(g1);
        assertEquals(30., t1.pricePerPerson(), 0);
    }
    
    @Test
	public void noChilds() {
		Person child = new Child("y2671090", "Pepe");
		g1.add(child);
		t1.add(g1);
		assertEquals(false, g1.add(child));
	}
    
    @Test
	public void tripSeptember() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/09/2012", "10/09/2012", 30);
		assertEquals(30, t1.pricePerPerson());
	}
    

    @Test
	public void tripNovember() {
		t1 = new Hiking("Passejant pel Montseny", 5, "15/11/2012", "22/11/2012", 30);
		assertEquals(33, t1.pricePerPerson());
	}
    
	@Test
	public void tripDecember() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/12/2012", "10/12/2012", 30);
		assertEquals(33, t1.pricePerPerson());
	}
	
	@Test
	public void tripJanuary() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/01/2012", "10/01/2012", 30);
		assertEquals(33, t1.pricePerPerson());
	}
	
	@Test
	public void tripFebruary() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/02/2012", "10/02/2012", 30);
		assertEquals(33, t1.pricePerPerson());
	}
    
    
    
}
