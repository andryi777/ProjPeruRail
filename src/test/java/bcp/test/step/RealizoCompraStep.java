package bcp.test.step;

import org.testng.Assert;

import bcp.test.pages.AppPago;
import bcp.test.util.GeneralUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class RealizoCompraStep {

	GeneralUtil generalUtil = new GeneralUtil();
	
	@Steps
	private AppPago appPago;

	@Step
	public void ingresoPago(String medioPago) {
		appPago.seleccionarMedioPago(medioPago);
		appPago.ingresarDatosTarjeta();
	}

	@Step
	public void validoMontoPagado(double montoEsperado) {
		String[] valorMostrado = appPago.obtenerValoresResumenCompra();
		
		for(int i=0; i<valorMostrado.length; i++) {
			System.out.println("Valor " + i + " " + valorMostrado[i]);
		}
		String montoTotal=valorMostrado[3];
		Assert.assertEquals(Double.parseDouble(montoTotal.replace(",", "")), montoEsperado);
	}

	@Step
	public void ingresoPagoExp(String medioPago) {
		appPago.seleccionarMedioPagoExp(medioPago);
		appPago.ingresarDatosTarjetaExp();
	}

	@Step
	public double[] getSubtotalesMostrados(int v_nroAdultosExpedition, int v_nroNinosExpedition) {
		return appPago.obtenerSubtotalesExpedition();
	}
}
