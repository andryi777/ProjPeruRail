package bcp.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.ConstantesUtil;
import bcp.test.util.GeneralUtil;
import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XpathPago;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class AppPago extends PageObject {

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;

	// xpath
	protected XpathPago xpathPago = XpathPago.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

	protected GeneralUtil generalUtil = GeneralUtil.getInstancia();

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void seleccionarMedioPago(String medioPago) {
		System.out.println("ingreso a Medio de Pago");
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.rbnMedioPago(medioPago), 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.rbnAceptTermiCondici, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.btnIngresarTarjeta, 0);
		Serenity.takeScreenshot();
	}

	public void ingresarDatosTarjeta() {
		System.out.println("ingresar Tarjeta");
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("global"));
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtNumTarjeta, 0, ConstantesUtil.nroTarjeta);
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathPago.cboMesExpiracion, ConstantesUtil.mesVencimiento);
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathPago.cboAnioExpiracion, ConstantesUtil.anioVencimiento);
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtCodigoSeguridad, 0, ConstantesUtil.codigoSeguridad);
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtNombreTarjeta, 0, ConstantesUtil.nombreTarjeta);

		getDriver().switchTo().defaultContent();
		Serenity.takeScreenshot();
	}

	public String[] obtenerValoresResumenCompra() {

		String[] datosMostrados = new String[4];
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.btnResumenCompra, 0);
		datosMostrados[0] = pageObjectUtil.seleniumGetText(getDriver(), xpathPago.lblDestino, 0);
		datosMostrados[1] = pageObjectUtil.seleniumGetText(getDriver(), xpathPago.lblTren, 0);
		datosMostrados[2] = pageObjectUtil.seleniumGetText(getDriver(), xpathPago.lblfechaSalida, 0);
		datosMostrados[3] = pageObjectUtil.seleniumGetText(getDriver(), xpathPago.lblMontoTotal, 0);

		Serenity.takeScreenshot();
		return datosMostrados;

	}

	public void seleccionarMedioPagoExp(String medioPago) {
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.rbnMedioPago(medioPago), 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.chkAceptarTermExp, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.chkAceptarEntenExp, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.btnCarritoCompra, 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.btnPagar, 0);
		pageObjectUtil.sleep(5);
	}

	public void ingresarDatosTarjetaExp() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeGC"));
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtNumTarjeta, 0, ConstantesUtil.nroTarjeta);
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathPago.cboMesExpiracion, ConstantesUtil.mesVencimiento);
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathPago.cboAnioExpiracion, ConstantesUtil.anioVencimiento);
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtCodigoSeguridad, 0, ConstantesUtil.codigoSeguridad);
		pageObjectUtil.seleniumEscribir(getDriver(), xpathPago.txtNombreTarjeta, 0, ConstantesUtil.nombreTarjeta);

		getDriver().switchTo().defaultContent();
	}

	public double[] obtenerSubtotalesExpedition() {
		pageObjectUtil.seleniumClick(getDriver(), xpathPago.btnCarritoCompra, 0);
		
		int contador = 0;
        double[] montos = new double[2];
        try {
            List<WebElement> elements = getDriver().findElements(By.xpath("//*[@src='/ecommerce/www/img/carrito.png'] /following :: div[2]//*[contains(text(),'Total: ')]"));
            for (WebElement row : elements) {
            	montos[contador]= Double.parseDouble(row.getText().replace("\n", "").substring(14,19));
            	contador++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		return montos;
	}

}
