import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test {
	
	private ArrayList<String> testList;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		System.out.println("@BeforeClass: onceExecutedBeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		
		testList = new ArrayList<String>();
		System.out.println("@Before: executedBeforeEach");
		
	}
/*
	@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void EmptyCollection() {
		assertTrue(testList.isEmpty());
		System.out.println("@Test: EmptyArrayList");
	}
	
	@Test
	public void OneItemCollection() {
		testList.add("oneItem");
		assertEquals(1, testList.size());
		System.out.println("@Test: OneItemArrayList");
	}

}
