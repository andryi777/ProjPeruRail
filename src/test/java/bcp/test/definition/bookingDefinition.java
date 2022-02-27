package bcp.test.definition;

import javax.swing.JOptionPane;

import org.testng.Assert;

import bcp.test.step.ConsultoTicketStep;
import bcp.test.step.IngresoDatosPersonalesStep;
import bcp.test.step.InicioPaginaStep;
import bcp.test.step.RealizoCompraStep;
import bcp.test.step.SeleccionCabinasBelmondStep;
import bcp.test.step.SeleccionTrenJourneyStep;
import bcp.test.util.GeneralUtil;
import bcp.test.util.VariablesUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class bookingDefinition extends VariablesUtil{

	@Steps
	private InicioPaginaStep inicioPaginaStep;
	@Steps
	private ConsultoTicketStep consultoTicketStep;
	@Steps
	private SeleccionCabinasBelmondStep seleccionCabinaBelmondStep;
	@Steps
	private IngresoDatosPersonalesStep ingresoDatosPersonalesStep;
	@Steps
	private RealizoCompraStep realizoCompraStep;
	@Steps
	private SeleccionTrenJourneyStep seleccionTrenJourneyStep;
    @Steps
    private GeneralUtil generalUtil;
	
	@Given("^Ingreso a la web de PeruRail$")
	public void ingreso_a_la_web_de_PeruRail() {
		inicioPaginaStep.ingresarPeruRail();
	}

	@Given("^selecciono tipo de ticket \"([^\"]*)\", destino \"([^\"]*)\", ruta \"([^\"]*)\"$")
	public void selecciono_tipo_de_ticket_destino_ruta(String tipoTicket, String destino, String ruta) {
		consultoTicketStep.seleccionarTipoTicketDestino(tipoTicket, destino, ruta);
	}

	@Given("^selecciono tren \"([^\"]*)\"$")
	public void selecciono_tren(String tren) {
		consultoTicketStep.seleccionarTren(tren);
	}

	@Given("^selecciono fecha salida \"([^\"]*)\"$")
	public void selecciono_fecha_salida(String fechaSalida) {
		consultoTicketStep.ingresoFechaSalida(fechaSalida);
	}

	@Given("^ingreso cantidad de pasajeros \"([^\"]*)\" adultos y \"([^\"]*)\" ninos$")
	public void ingreso_cantidad_de_pasajeros_adultos_y_ninos(String nroAdultos, String nroNinos) {
		consultoTicketStep.seleccionoPasajeros(nroAdultos, nroNinos);
		v_nroAdultosExpedition = Integer.parseInt(nroAdultos);
		v_nroNinosExpedition = Integer.parseInt(nroNinos);
	}

	@Given("^consulto ticket$")
	public void consulto_ticket() {
		consultoTicketStep.consultoTicket();
	}

	@Given("^selecciono tipo cabina \"([^\"]*)\" y numero de cabinas \"([^\"]*)\"$")
	public void selecciono_tipo_cabina_y_numero_de_cabinas(String tipoCabina, String nroCabinas) {
		seleccionCabinaBelmondStep.seleccionoCabina(tipoCabina, nroCabinas);
		v_tipoCabina = tipoCabina;
		v_nroCabinas = Integer.parseInt(nroCabinas.substring(0, 1));
	}

	@Given("^ingreso cantidad de pasajeros \"([^\"]*)\" adultos y \"([^\"]*)\" ninos por cabina$")
	public void ingreso_cantidad_de_pasajeros_adultos_y_ninos_por_cabina(String grupoAdultos, String grupoNinos) {
		seleccionCabinaBelmondStep.seleccionoNroPasajeros(grupoAdultos, grupoNinos, v_tipoCabina, v_nroCabinas);
		v_grupoAdultos = grupoAdultos;
		v_grupoNinos = grupoNinos;
	}

	@Given("^ingreso datos personales de los pasajeros Belmond$")
	public void ingreso_datos_personales_de_los_pasajeros_Belmond() {
		ingresoDatosPersonalesStep.ingresoDatosPasajerosBelmond(v_grupoAdultos, v_grupoNinos, v_tipoCabina, v_nroCabinas);
	}
	
	@Given("^ingreso datos personales de los pasajeros Expedition$")
	public void ingreso_datos_personales_de_los_pasajeros_Expedition() {
		ingresoDatosPersonalesStep.ingresoDatosPasajerosExpedition(v_nroAdultosExpedition, v_nroNinosExpedition);
	}

	@Given("^realizo compra según medio de pago \"([^\"]*)\"$")
	public void realizo_compra_según_medio_de_pago(String medioPago) {
		realizoCompraStep.ingresoPago(medioPago);
	}

	@Given("^realizo compra en Expedition según medio de pago \"([^\"]*)\"$")
	public void realizo_compra_en_Expedition_según_medio_de_pago(String medioPago) {
		realizoCompraStep.ingresoPagoExp(medioPago);
	}
	
	@Then("^valido el monto pagado por servicio Belmond$")
	public void valido_el_monto_pagado_por_servicio_Belmond() {
    	double montoCalculado=generalUtil.calcularMontoTarifarioBelmond(VariablesUtil.v_tipoCabina, generalUtil.getTotalPasajeros(VariablesUtil.v_grupoAdultos, VariablesUtil.v_grupoNinos));
		realizoCompraStep.validoMontoPagado(montoCalculado);
	}

	@Then("^valido el monto pagado por servicio Expedition$")
	public void valido_el_monto_pagado_por_servicio_Expedition() {
		realizoCompraStep.compararMonto(v_nroAdultosExpedition, v_nroNinosExpedition);
	}
	
	@Given("^selecciono fecha salida \"([^\"]*)\" y fecha retorno \"([^\"]*)\"$")
	public void selecciono_fecha_salida_y_fecha_retorno(String fechaSalida, String fechaRetorno) {
		consultoTicketStep.ingresoFechaSalida(fechaSalida);
		if(fechaRetorno.compareTo("No Aplica")==1) consultoTicketStep.ingresoFechaRetorno(fechaRetorno);
	}

	@Given("^selecciono tren salida \"([^\"]*)\" y tren retorno \"([^\"]*)\"$")
	public void selecciono_tren_partida_y_tren_retorno(String trenSalida, String trenRetorno) {
		seleccionTrenJourneyStep.seleccionoTren(trenSalida,trenRetorno);
	}

	@Then("^debe mostrarse mensaje de error \"([^\"]*)\"$")
	public void debe_mostrarse_mensaje_de_error(String mensajeErrorEsperado) {
    	String mensajeErrorObtenido = consultoTicketStep.getMensajeNroMaxPasajeros();
    	System.out.println(" :" + mensajeErrorObtenido);
    	Assert.assertEquals(mensajeErrorObtenido.trim(), mensajeErrorEsperado.toUpperCase().trim());
	}

}
