package bcp.test.xpath;

public class XpathPago {
	// singleton
    private static XpathPago obj = null;

    private XpathPago() {
    }

    public static XpathPago getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathPago();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    

    public String rbnMedioPago(String medioPago) {
 	   final String rbnMedioPago="//input[@id='"+medioPago+"']";
 	    return rbnMedioPago;
    }
    
    public final String rbnAceptTermiCondici="//input[@name='tipo-manera']";
    public final String chkAceptarTermExp="//input[@name='terms']";
    public final String btnIngresarTarjeta="//input[@value='Enter your card number']";
    public final String btnCarritoCompra="//*[@id='compra']/a/div[@class='logo-tren-normal']";
    public final String btnPagar="//input[@value='PAY']";
    public final String chkAceptarEntenExp="//input[@name='termsBimodal']";
    
    public final String txtNumTarjeta="//input[@name='CREDITCARDNUMBER']";
    public final String cboMesExpiracion="//label[contains(text(),'Expiration date:')]//following::select[1]";
    public final String cboAnioExpiracion="//label[contains(text(),'Expiration date:')]//following::select[2]";
    public final String txtCodigoSeguridad="//label[contains(text(),'Security code:')]//following::input[1]";
    public final String txtNombreTarjeta="//label[contains(text(),'Name (as on card):')]//following::input[1]";
    public final String btnContinuar="//input[@value='Continue']";
    
    public final String btnResumenCompra="//*[@src='https://pax3.perurail.com/ecommerceaep/images/carrito-be.png']"; 
    public final String lblDestino="//*[@class='destino']";
    public final String lblTren="//*[@class='detalle-compra']//../*[@class='firts' and text()='Train:']/following::div[1]";
    public final String lblfechaSalida="//*[@class='detalle-compra']//../*[@class='firts' and text()='Departure Date:']/following::div[1]";
    public final String lblMontoTotal="//*[@class='total']/div/span[text()='USD ']/span";
   

    
    
}
