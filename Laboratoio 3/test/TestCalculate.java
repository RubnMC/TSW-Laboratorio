import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import Calc.Calculate;

class TestCalculate {

	Calculate aux;
	
	@Before
	public void initialize() {
		aux = new Calculate();
	}
	
	@Test //Camino 1, 2, 9
	void testCalSameMonth() {
		aux = new Calculate();
		assertEquals(2, aux.cal(2, 12, 2, 14, 2020));
	}
	
	@Test //Camino 1, 3, 4, 6, 7, 9
	void testCalNotLoop() {
		aux = new Calculate();
		assertEquals(30, aux.cal(2, 12, 3, 14, 2021));
	}
	
	@Test //Camino 1, 3, 4, 6, 7, 8, 7, 9
	void testCalOneLoop() {
		aux = new Calculate();
		assertEquals(91, aux.cal(2, 12, 5, 14, 2021));
	}

	@Test //Camino 1, 3, 5, 6, 7, 8, 7, 8, 7, 9
	void testCalVariusLoops() {
		aux = new Calculate();
		assertEquals(123, aux.cal(2, 12, 6, 14, 2024));
	}
}
