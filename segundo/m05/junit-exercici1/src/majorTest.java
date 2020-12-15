import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class majorTest {
	
	/*
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
	}*/

	/*
	@Test
	void test() {
		
	}*/
	
	@Test
	public void OneItemCollection() {
		
		//Simple con 4 números
		
		int[] lista = { 3, 7, 9, 8};
		assertEquals(9, Major.mayor(lista));
		
		//Duplicados
		/*
		int[] lista =  {9, 7, 9, 8};
		assertEquals(9, Major.mayor(lista));*/
		
		//Unico valor
		/*
		int[] lista =  {7};
		assertEquals(7, Major.mayor(lista));*/
		
		//Valores negativos
		/*
		int[] lista = {-4, -6, -7, 22};
		assertEquals(22, Major.mayor(lista));*/
		
		//Lista vacía
		/*
		int[] lista = new int[0];
		assertThrows(RuntimeException.class,() -> Major.mayor(lista));*/
		
		
	}

}
