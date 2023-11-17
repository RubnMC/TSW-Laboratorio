package Carreras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultadosCarrerasTest {

	Cliente dummyCliente;
	Mensaje dummyMensaje;
	ResultadosCarreras resCarreras;

	@BeforeEach
	void setup() {
		dummyCliente = mock(Cliente.class);
		dummyMensaje = mock(Mensaje.class);
		resCarreras = new ResultadosCarreras();
	}

	@Test
	void testMensajeUsuarioNoSuscrito() {
		resCarreras.enviar(dummyMensaje);
		verify(dummyCliente, never()).recibe(dummyMensaje);
	}

	@Test
	void testMensajeRecibidoUnaVez() {
		resCarreras.nuevaSuscripcion(dummyCliente);
		resCarreras.enviar(dummyMensaje);
		verify(dummyCliente, times(1)).recibe(dummyMensaje);
	}
	
	@Test
	void testClienteDeBajaNoRecibe() {
		resCarreras.nuevaSuscripcion(dummyCliente);
		resCarreras.bajaSuscripcion(dummyCliente);
		resCarreras.enviar(dummyMensaje);
		verify(dummyCliente, never()).recibe(dummyMensaje);
	}

	@Test
	void testClienteSuscripcionDuplicadaRecibe() {
		resCarreras.nuevaSuscripcion(dummyCliente);
		resCarreras.nuevaSuscripcion(dummyCliente);
		resCarreras.enviar(dummyMensaje);
		verify(dummyCliente, times(1)).recibe(dummyMensaje);
	}
}
