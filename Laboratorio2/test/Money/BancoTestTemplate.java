package Money;

import static org.junit.Assert.*;

import java.util.Hashtable;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.*;
import org.junit.rules.*;

public class BancoTestTemplate {
	Divisa SEK, DKK;
	Banco Nordea, DanskeBanco;
	Money importe;
	Hashtable<String, Cuenta> listacuentas;

	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.087);
		DKK = new Divisa("DKK", 0.13);
		
		Nordea = new Banco("Nordea", SEK);
		Nordea.abrirCuenta("Pepe", "1");
		
		listacuentas = new Hashtable<>();
		listacuentas.put("1", new Cuenta("Pepe", DKK));
		
		DanskeBanco = new Banco("DanskeBanco", DKK);
		importe = new Money(1000, SEK);
	}

	@Test
	public void testGetNombre() {
		assertEquals("Nordea", Nordea.getNombre());
	}

	@Test
	public void testGetDivisa() {
		assertSame(SEK, Nordea.getDivisa());
	}

	@Test
	public void testGetCuentas() {
		assertEquals(listacuentas, Nordea.getCuentas());
	}

	// Abrir cuenta Inexistente
	@Test
	public void testAbrirNuevaCuenta() throws CuentaExisteException {
		Nordea.abrirCuenta("Manolo", "2");
		assertEquals(new Cuenta("Manolo", SEK), Nordea.getCuentas().get("2"));
	}

	// Abrir cuenta Existente
	@Test(expected = CuentaExisteException.class)
	public void testAbrirCuentaExistenteException() throws CuentaExisteException{
		Nordea.abrirCuenta("Carlos", "1");
	}

	// Recuperar Saldo cuenta Existente
	@Test
	public void testGetSaldoCuentaExistente() {

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// Recuperar Saldo cuenta Inexistente
	@Test
	public void testGetSaldoCuentaNoExistente() {

	}

	// Deposito cuenta Existente
	@Test
	public void testDeposito() {

	}

	// Deposito cuenta Inexistente
	@Test
	public void testDepositoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {

	}

	// Reintegro cuenta Existente con saldo suficiente
	@Test
	public void testReintegro() {

	}

	// Reintegro cuenta Inexistente
	@Test
	public void testReintegroCuentaNoExisteException() {

	}

	// Reintegro cuenta Existente con saldo Insuficiente
	@Test
	public void testReintegroSaldoInsuficienteException() {

	}

	// Transfer a otro Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferOtroBanco() {

	}

	// Transfer a otro Banco a cuenta inexistente
	@Test
	public void testTransferOtroBancoCuentaNoExisteException() {

	}

	// Transfer a otro Banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferOtroBancoSaldoInsuficienteException() {

	}

	// Transfer a mismo Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferMismoBanco() {

	}

	// Transfer mismo Banco a cuenta inexistente
	@Test
	public void testTransferMismoBancoCuentaNoExisteException() {

	}

	// Transfer a mismo banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferMismoBancoSaldoInsuficienteException() {

	}

}
