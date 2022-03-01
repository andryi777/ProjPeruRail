package bcp.test.xpath;

public class XpathTrenExpedition {

	// singleton
	private static XpathTrenExpedition obj = null;

	private XpathTrenExpedition() {
	}

	public static XpathTrenExpedition getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XpathTrenExpedition();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public String xpathTipoTrenSalida(String tren) {
		final String xpathTrenSalida = "//div[@id='viajeIdaBimodal']//div[contains(text(),'" + tren + "')]//following::div[2]";
		return xpathTrenSalida;
	}

	public String xpathTipoTrenRetorno(String tren) {
		final String xpathTrenRetorno = "//div[@id='viajeRegresoBimodal']//div[contains(text(),'" + tren + "')]//following::div[2]";
		return xpathTrenRetorno;
	}

	public String xpathMontoIndividualSalida(String tren) {
		final String lblMontoIndividualSalida = "//div[@id='viajeIdaBimodal']//div[contains(text(),'" + tren + "')]//following :: div[4]";
		return lblMontoIndividualSalida;
	}

	public String xpathMontoIndividualRetorno(String tren) {
		final String lblMontoIndividualRetorno = "//div[@id='viajeRegresoBimodal']//div[contains(text(),'" + tren + "')]//following :: div[5]";
		return lblMontoIndividualRetorno;
	}

	public final String btnCerrar = "//*[@title='Close']";
	public final String btnResumenCompra = "//*[@class='logo-tren-normal']//*[@src='/ecommerce/www/img/carrito.png']";
	public final String btnContinuar = "//input[@class='btn  btn-continuar']";

}
