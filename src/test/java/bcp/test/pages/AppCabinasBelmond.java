package bcp.test.pages;

import javax.swing.JOptionPane;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XpathCabinasBelmond;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppCabinasBelmond extends PageObject {	

	private long wdwTimeOut = 300L;
	
    // xpath
    protected XpathCabinasBelmond xpathCabinasBelmond = XpathCabinasBelmond.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void seleccionarNroCabinas(String tipoCabina, String nroCabinas) {
    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathCabinasBelmond.cboNroCabinasxTipoCabina(tipoCabina), nroCabinas);
	}
	
	public void seleccionarNroPasajeros(String auxTipoCabina, int nroCabinas, String nroPasajeros, int tipoPasajero) {
		pageObjectUtil.seleniumClick(getDriver(), xpathCabinasBelmond.cboNroCabinaAdultoNino(auxTipoCabina, nroCabinas, tipoPasajero), 0);
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathCabinasBelmond.cboNroCabinaAdultoNino(auxTipoCabina, nroCabinas, tipoPasajero), nroPasajeros);
		Serenity.takeScreenshot();
	}
	
	public void seleccionarContinuar() {
		pageObjectUtil.seleniumClick(getDriver(), xpathCabinasBelmond.btnContinuar,0);
		Serenity.takeScreenshot();
	}

	public String mensajeValidacion1Adulto() {
		String mensajeObtenido = pageObjectUtil.seleniumGetText(getDriver(), xpathCabinasBelmond.lblMin1Adulto,0);
		return mensajeObtenido;
	}

}
