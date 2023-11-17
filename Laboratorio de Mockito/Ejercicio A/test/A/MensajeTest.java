package A;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MensajeTest {
	
	@Test
	void testsendMensaje() {
		Cliente dummyCliente = mock(Cliente.class);
		Template dummyTemplate = mock(Template.class);
		MailServer dummyMailServer = mock(MailServer.class);
		TemplateEngine dummyTE =  mock(TemplateEngine.class);
		Mensaje mensaje = new Mensaje(dummyMailServer, dummyTE);
		
		
		when(dummyCliente.getEmail()).thenReturn("HolaSOyUNMAIL");
		when(dummyTE.preparaMensaje(any(Template.class), any(Cliente.class))).thenReturn("Mensaje");
		
		mensaje.sendMensaje(dummyCliente, dummyTemplate);
		verify(dummyMailServer).send("HolaSOyUNMAIL","Mensaje");
	}

}
