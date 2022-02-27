package bcp.test.xpath;

import javax.swing.JOptionPane;

public class XpathCabinasBelmond {

	// singleton
    private static XpathCabinasBelmond obj = null;

    private XpathCabinasBelmond() {
    }

    public static XpathCabinasBelmond getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathCabinasBelmond();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

   
    public String cboNroCabinasxTipoCabina(String tipoCabina) {
    	final String lstTipoCabina="//h3[.='"+tipoCabina+"']//following::select[1]";
		return lstTipoCabina;
    }
    
	public String cboNroCabinaAdultoNino(String tipoCabina, int numCabina,int tipoPasajero) {
    	final String selNumPasajeros="//*[@class='box-cabina']/div[@class='detalle-cabina']//*[contains(text(),'"+tipoCabina+"')]// following :: div[2]//*[text()='CABIN "+numCabina+"']//following :: select["+tipoPasajero+"]";
    	return selNumPasajeros;
    }
    
    public final String btnContinuar="//input[@value='Continue']";
}
