package travelagency;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WalkingTest {
	
	private static Trip t1;
    private static Person a1;
    private static Group g1;

	@BeforeEach
	void setUp() throws Exception {
		
		t1 = new Hiking("Passejant pel Montseny", 5, "10/06/2012", "10/06/2012", 30);
        a1 = new Adult("11", "Joan Grau");
        g1 = new Group();
	}
	
	@Test
	void testMas75() {
		Person persona1 = new Adult("y2671855", "Jose");
		Person persona2 = new Adult("y2671830", "Pepe");
		Person persona3 = new Adult("y2671860", "Pepe");
		Person persona4 = new Adult("y2671840", "Pepe");
		Person persona5 = new Adult("y2671850", "Pepe");
		Person persona6 = new Adult("y3671850", "Pepe");
		Person persona7 = new Adult("y4671850", "Pepe");
		Person persona8 = new Adult("y7671850", "Pepe");
		Person persona9 = new Adult("y5671855", "Pepe");
		Person persona10 = new Adult("y5671857", "Pepe");
		g1.add(persona1);
		g1.add(persona2);
		g1.add(persona3);
		g1.add(persona4);
		g1.add(persona5);
		g1.add(persona6);
		g1.add(persona7);
		g1.add(persona8);
		g1.add(persona9);
		g1.add(persona10);
		
		t1.add(g1);
		
		assertEquals(27., t1.pricePerPerson());
		
	}

}
