package bcp.test.step;

import bcp.test.pages	.AppPeruRail;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ConsultoTicketStep {

	
	@Steps
	private AppPeruRail appPeruRail;
	
	@Step
	public void seleccionarTipoTicketDestino(String tipoTicket, String destino, String ruta) {
		appPeruRail.ingresarTipoTicket(tipoTicket);
		appPeruRail.ingresarDestino(destino);
		appPeruRail.ingresarRuta(ruta);
	}

	public void seleccionarTren(String tren) {
		appPeruRail.ingresarTren(tren);
	}

	public void ingresoFechaSalida(String fechaSalida) {
		appPeruRail.ingresarFechaSalida(fechaSalida);
	}

	public void seleccionoPasajeros(String nroAdultos, String nroNinos) {
		int numeAdulto=Integer.parseInt(nroAdultos);
		int numeNinos=Integer.parseInt(nroNinos);
		
		appPeruRail.ingresarNumeroPasajeros(numeAdulto,numeNinos);
	}
	
	@Step
	public void consultoTicket() {
		appPeruRail.consultarTicket();		
	}

	public void ingresoFechaRetorno(String fechaRetorno) {
		appPeruRail.ingresarFechaRetorno(fechaRetorno);
	}

	public String getMensajeNroMaxPasajeros() {
		String mensajeMostrado = appPeruRail.getMensajeNroMaxPasajeros();
		
		return mensajeMostrado;
	}

}
