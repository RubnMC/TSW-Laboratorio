package B;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class WebVerificatorTest {
	
	Logger dummyLogger;
	WebVerificator webVerificator;
	Result dummyResult;
	Web dummyWeb;
	Server dummyServer;
	
	
	@BeforeEach
	void setUp() {
		dummyLogger = mock(Logger.class);
		dummyResult = mock(Result.class);
		dummyWeb = mock(Web.class);
		dummyServer = mock(Server.class);
		webVerificator = new WebVerificator(dummyLogger);
	}

	@Test
	void testWebOK() {
		when(dummyServer.connect(dummyWeb)).thenReturn(dummyResult);
		when(dummyResult.isOk()).thenReturn(true);
		
		webVerificator.checkWeb(dummyServer, dummyWeb);
		
		verify(dummyLogger).registerWebisOk(dummyWeb);
	}
	
	@Test
	void testWebFail() {
		when(dummyServer.connect(dummyWeb)).thenReturn(dummyResult);
		when(dummyResult.isOk()).thenReturn(false);		
		
		webVerificator.checkWeb(dummyServer, dummyWeb);
		
		verify(dummyLogger).registerWebReturnedError(dummyWeb,dummyResult);
	}

}
