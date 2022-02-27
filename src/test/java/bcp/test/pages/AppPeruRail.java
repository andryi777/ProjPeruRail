package bcp.test.pages;

import java.util.concurrent.TimeUnit;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XPathHomePeruRail;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppPeruRail extends PageObject {

	private long wdwTimeOut = 300L;
	
	// xpath
	protected XPathHomePeruRail xpathHomePeruRail = XPathHomePeruRail.getInstancia();

	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();


	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void inicializar() {
		getDriver().get("https://www.perurail.com/");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);		
	}

	public void ingresarTipoTicket(String tipoTicket) {
    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.rbnTipoViaje(tipoTicket),0);
	}

	public void ingresarDestino(String destino) {
    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathHomePeruRail.lstDestino, destino);
	}

	public void ingresarRuta(String ruta) {
    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathHomePeruRail.lstRuta, ruta);
	}
	
	public void ingresarTren(String tren) {
    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathHomePeruRail.lstTipoTren, tren);
	}

	public void ingresarFechaSalida(String fechaSalida) {
	   	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.txtFechaSalida, 0);
	   	pageObjectUtil.seleccionarDatepicker(getDriver(), xpathHomePeruRail.dtpFecha, fechaSalida);
	   	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.lblFechaDia(fechaSalida), 0);
	}

	public void ingresarFechaRetorno(String fechaRetorno) {
    	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.txtFechaRetorno, 0);
    	pageObjectUtil.seleccionarDatepicker(getDriver(), xpathHomePeruRail.dtpFecha, fechaRetorno);
	   	pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.lblFechaDia(fechaRetorno), 0);
	}

	public void consultarTicket() {
		Serenity.takeScreenshot();
		pageObjectUtil.seleniumClick(getDriver(), xpathHomePeruRail.btnBuscarTicket, 0);
	}

	public void ingresarNumeroPasajeros(int nroAdultos, int nroNinos) {
		pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRail.btnPasajeros,0);
		if(nroAdultos>=2) {
			for(int i=0; i<nroAdultos-2;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRail.btnAumentarAdulto,0);
			}
		}else {
			pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRail.btnDisminuirAdulto,0);
		}
		
		if(nroNinos>0) {
			for(int i=0; i<nroNinos;i++) {
				pageObjectUtil.seleniumClick(getDriver(),xpathHomePeruRail.btnAumentarNino,0);
			}
		}
	}

	public String getMensajeNroMaxPasajeros() {
		String mensaje = pageObjectUtil.seleniumGetText(getDriver(), xpathHomePeruRail.lblErrorMaxPasajeros, 0);
		return mensaje;
	}
	
}
