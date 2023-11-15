package Carreras;


import java.util.*;

public class ResultadosCarreras {
	
		private Collection<Cliente> clientes = new ArrayList<Cliente>();

		public void nuevaSuscripcion(Cliente cliente) {
			clientes.add(cliente);
		}

		public void enviar(Mensaje mensaje) {
			for (Cliente cliente : clientes) {
				cliente.recibe(mensaje);
			}
		}

		public void bajaSuscripcion(Cliente cliente) {
			clientes.remove(cliente);
		}
}
