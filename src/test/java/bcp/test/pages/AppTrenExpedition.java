package bcp.test.pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XpathTrenExpedition;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppTrenExpedition  extends PageObject {

	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected XpathTrenExpedition xpathTrenExpedition = XpathTrenExpedition.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}
    
    public double seleccionarTrainSalida(String tren) {
		pageObjectUtil.seleniumClick(getDriver(), xpathTrenExpedition.xpathTipoTrenSalida(tren),0);
		Serenity.takeScreenshot();
		String montoIndividual=pageObjectUtil.seleniumGetText(getDriver(), xpathTrenExpedition.xpathMontoIndividualSalida(tren),0);
		return Double.parseDouble(montoIndividual.substring(4,10));
	}
	
	public double seleccionarTrainRegreso(String tren) {
		pageObjectUtil.seleniumClick(getDriver(), xpathTrenExpedition.xpathTipoTrenRetorno(tren),0);
		Serenity.takeScreenshot();
		String montoIndividual=pageObjectUtil.seleniumGetText(getDriver(), xpathTrenExpedition.xpathMontoIndividualRetorno(tren),0);
		return Double.parseDouble(montoIndividual.substring(4,10));
	}

	public void seleccionarResumenCompra() {
		pageObjectUtil.sleep(3);
		pageObjectUtil.seleniumClick(getDriver(), xpathTrenExpedition.btnResumenCompra, 0);
	}

	public void seleccionarContinuar() {
		pageObjectUtil.seleniumClick(getDriver(), xpathTrenExpedition.btnContinuar, 0);	
	}

}
