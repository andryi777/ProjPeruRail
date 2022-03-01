package bcp.test.xpath;

public class XPathHomePeruRail {

	private static XPathHomePeruRail obj = null;

	private XPathHomePeruRail() {
	}

	public static XPathHomePeruRail getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new XPathHomePeruRail();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public String rbnTipoViaje(String tipoViaje) {
    	final String rbnTipoViaje="//label[text()='"+tipoViaje+"']//span";
		return rbnTipoViaje;
    }
	
    public final String lstDestino = "//select[@name='destinoSelect']";
    public final String lstRuta="//select[@name='rutaSelect']";
    
    public final String lstTipoTren="//select[@name='cbTrenSelect']";
    
    public final String btnPasajeros="//input[@name='countParentsChildren']";
    public final String btnDisminuirAdulto="//a[@id='adultsDism']";
    public final String btnAumentarAdulto="//a[@id='adultsAume']";
    public final String btnDisminuirNino="//a[@id='childrenDism']";
    public final String btnAumentarNino="//a[@id='childrenAume']";
    public final String btnCerrarPassenger="//a[@class='cerrar-passanger']";
    
    public final String txtFechaSalida="//input[@name='salida']";
    public final String dtpFecha="//span[@class='ui-datepicker-month']";
    public final String txtFechaRetorno="//input[@name='regreso']";
    
    public String lblFechaDia(String fecha) {
    	String dia = fecha.split("-")[0];
    	final String lblFechaDia="//td[@data-handler='selectDay']//*[text()="+dia+"]";
    	return lblFechaDia;
    }
    
    public final String btnBuscarTicket="//span[text()='Find Train tickets']";
    
    public final String lblErrorMaxPasajeros="//*[@id='error-pasajeros']";

	
}
