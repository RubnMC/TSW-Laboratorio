package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;

public class DivisaTestTemplate {
	Divisa SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertTrue("Expected: SEK", SEK.getName().equals("SEK"));
	}

	@Test
	public void testGetRate() {
		assertEquals((Double) 0.15, SEK.getRate());
	}

	@Test
	public void testSetRate() {
		assertEquals((Double) 0.20, DKK.getRate());
		DKK.setRate(0.25);
		assertEquals((Double) 0.25, DKK.getRate());
	}

	@Test
	public void testGlobalValue() {
		fail("No implementado");
	}

	@Test
	public void testValueEnEstaDivisa() {
		fail("No implementado");
	}

}
