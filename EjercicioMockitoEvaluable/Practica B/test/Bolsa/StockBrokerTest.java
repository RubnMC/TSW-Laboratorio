package Bolsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockBrokerTest {
	
	Stock stock, stockCaido;
	StockBroker stockBroker;
	AnalistaMercado dummyAnalista;
	Portfolio dummyPortfolio;
	

	@BeforeEach
	void setUp(){
		stock = new Stock("1", "StockEx", new BigDecimal(98));
		dummyAnalista = mock(AnalistaMercado.class);
		stockBroker = new StockBroker(dummyAnalista);
		dummyPortfolio = mock(Portfolio.class);
	}

	@Test
	void testMercadoCaido() throws Exception {
		
		when(dummyAnalista.getCotizacion(stock.getSimbolo())).thenThrow(new IllegalStateException("Mercado Caido"));
		
		try{
			stockBroker.perform(dummyPortfolio, stock);	
		} catch(IllegalStateException e) {
			assertEquals(e.getMessage(), "Mercado Caido");
		}
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
