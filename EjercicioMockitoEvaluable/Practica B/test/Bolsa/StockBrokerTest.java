package Bolsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockBrokerTest {
	
	Stock stock;
	StockBroker stockBroker;
	AnalistaMercado dummyAnalista;
	Portfolio dummyPortfolio;
	

	@BeforeEach
	void setUp(){
		stock = new Stock("1", "StockEx", new BigDecimal(12312312));
		dummyAnalista = mock(AnalistaMercado.class);
		stockBroker = new StockBroker(dummyAnalista);
		dummyPortfolio = mock(Portfolio.class);
	}

	@Test
	void testMercadoCaido() throws Exception {
		fail("hola");
	}
	
	@Test
	void testValorPositivo() {
		Stock liveStock = new Stock("2", "StockLive", new BigDecimal(100));
		
		when(dummyAnalista.getCotizacion(stock.getSimbolo())).thenReturn(liveStock);
		when(dummyPortfolio.getAvgPrecio(stock)).thenReturn(new BigDecimal(1));
		
		stockBroker.perform(dummyPortfolio, stock);
		
		verify(dummyPortfolio).vender(stock, 10);
		verify(dummyPortfolio, never()).comprar(stock);
	}
	
	@Test
	void testValorNegativo() {
		Stock liveStock = new Stock("2", "StockLive", new BigDecimal(100));
		
		when(dummyAnalista.getCotizacion(stock.getSimbolo())).thenReturn(liveStock);
		when(dummyPortfolio.getAvgPrecio(stock)).thenReturn(new BigDecimal(101));
		
		stockBroker.perform(dummyPortfolio, stock);
		
		verify(dummyPortfolio).comprar(stock);
		verify(dummyPortfolio, never()).vender(stock, 10);
	}

}
