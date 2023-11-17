package PA;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmisorFacturaTest {

	PrinterService dummyPrinterService;
	EmailService dummyEmailService;
	Factura dummyFactura;
	Cliente dummyCliente;
	EmisorFactura emisorFactura;
	
	@BeforeEach
	void setUp(){
		dummyPrinterService = mock(PrinterService.class);
		dummyEmailService = mock(EmailService.class);
		dummyFactura = mock(Factura.class);
		dummyCliente = mock(Cliente.class);
		
		emisorFactura = new EmisorFactura(dummyPrinterService, dummyEmailService);
	}

	@Test
	void emitirFacturaEmail() {
		when(dummyCliente.prefiereEmails()).thenReturn(true);
		when(dummyCliente.getEmail()).thenReturn("unMail");
		
		emisorFactura.emitirFactura(dummyFactura, dummyCliente);
		
		verify(dummyEmailService).sendFactura(dummyFactura, "unMail");
		verify(dummyPrinterService, never()).printFactura(dummyFactura);
	}
	
	@Test
	void emitirFacturaFisica() {
		when(dummyCliente.prefiereEmails()).thenReturn(false);
		
		emisorFactura.emitirFactura(dummyFactura, dummyCliente);
		
		verify(dummyEmailService, never()).sendFactura(dummyFactura, "unMail");
		verify(dummyPrinterService).printFactura(dummyFactura);
	}

}
