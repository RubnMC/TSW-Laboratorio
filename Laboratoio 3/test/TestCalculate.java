import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Calc.Calculate;

class TestCalculate {

	Calculate aux;
	
	@BeforeEach
	public void setUp() {
		aux = new Calculate();
	}
	
	@Test //Camino 1, 2, 9
	void test1CalSameMonth() {
		assertEquals(2, aux.cal(2, 12, 2, 14, 2020));
	}
	
	@Test //Camino 1, 3, 4, 6, 7, 9
	void test2CalNotLoop() {
		assertEquals(30, aux.cal(2, 12, 3, 14, 2021));
	}
	
	@Test //Camino 1, 3, 4, 6, 7, 8, 7, 9
	void test3CalOneLoop() {
		assertEquals(91, aux.cal(2, 12, 5, 14, 2021));
	}

	@Test //Camino 1, 3, 5, 6, 7, 8, 7, 8, 7, 9
	void test4CalVariusLoops() {
		assertEquals(123, aux.cal(2, 12, 6, 14, 2024));
	}
	
	@Test //Matar mutante 3
	void test5CalJanuary() {
		assertEquals(33, aux.cal(1, 12, 2, 14, 2021));
	}
}
