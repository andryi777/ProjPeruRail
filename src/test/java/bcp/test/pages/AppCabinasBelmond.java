package bcp.test.pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XpathCabinasBelmond;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppCabinasBelmond extends PageObject {	

	private WebDriverWait wdw = null;
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
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathCabinasBelmond.cboNroCabinaAdultoNino(auxTipoCabina, nroCabinas, tipoPasajero), nroPasajeros);
		Serenity.takeScreenshot();
	}
	
	public void seleccionarContinuar() {
		pageObjectUtil.seleniumClick(getDriver(), xpathCabinasBelmond.btnContinuar,0);
		Serenity.takeScreenshot();
	}

}
