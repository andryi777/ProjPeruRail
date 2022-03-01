package bcp.test.pages;

import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;

import bcp.test.util.ConstantesUtil;
import bcp.test.util.GeneralUtil;
import bcp.test.util.PageObjectUtil;
import bcp.test.xpath.XpathDatosPersonales;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppDatosPasajeros extends PageObject {
	
	private WebDriverWait wdw = null;
	private long wdwTimeOut = 300L;
	
    // xpath
    protected XpathDatosPersonales xpathDatosPersonales = XpathDatosPersonales.getInstancia();

    // util
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    GeneralUtil generalUtil;
    int cont_Adultos=0;
    
    public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void ingresarDatosPersonales(String tipoPasajero, int contadorCabina, String string, int contadorPasajero) {
    	
		if(pageObjectUtil.seleniumEsVisible(getDriver(), xpathDatosPersonales.txtPrimerNombre(contadorCabina, contadorPasajero),0)==false) {
			if(tipoPasajero.compareTo("ADULTO")==0) {
				pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.lstCabina(contadorCabina), 0);
				pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.lstPasajeroxCabina(contadorCabina, contadorPasajero), 0);				
			}else
				pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.lstPasajeroxCabina(contadorCabina, contadorPasajero), 0);
		}
		
		if(tipoPasajero.compareTo("ADULTO")==0) {
			pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtPrimerNombre(contadorCabina, contadorPasajero), 0, ConstantesUtil.nomAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtApellido(contadorCabina, contadorPasajero), 0, ConstantesUtil.apeAdulto);
	    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtFecNacimiento(contadorCabina, contadorPasajero), 0);
	    	
	    	seleccionarFechaCalendario(ConstantesUtil.fecNacimientoAdulto);
	    	
			pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboNacionalidad(contadorCabina, contadorPasajero), ConstantesUtil.nacionalidadAdulto);	   	
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboTipoDocumento(contadorCabina, contadorPasajero), ConstantesUtil.tipoDocumentoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtNroDocumento(contadorCabina, contadorPasajero), 0, String.valueOf(10000000 + new Random().nextInt(90000000)));
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboSexo(contadorCabina, contadorPasajero), ConstantesUtil.sexoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtTelefono(contadorCabina, contadorPasajero), 0, ConstantesUtil.telefonoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtCorreo(contadorCabina, contadorPasajero), 0, ConstantesUtil.correoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtCorreoConfirmacion(contadorCabina, contadorPasajero), 0, ConstantesUtil.correoAdulto);

		}else {
			pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtPrimerNombre(contadorCabina, contadorPasajero), 0, ConstantesUtil.nomNino);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtApellido(contadorCabina, contadorPasajero), 0, ConstantesUtil.apeNino);
	    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtFecNacimiento(contadorCabina, contadorPasajero), 0);
	    	
	    	seleccionarFechaCalendario(ConstantesUtil.fecNacimientoNino);
	    	
			pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboNacionalidad(contadorCabina, contadorPasajero), ConstantesUtil.nacionalidadNino);	   	
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboTipoDocumento(contadorCabina, contadorPasajero), ConstantesUtil.tipoDocumentoNino);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtNroDocumento(contadorCabina, contadorPasajero), 0, ConstantesUtil.nroDocNino);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboSexo(contadorCabina, contadorPasajero), ConstantesUtil.sexNino);
		}
		Serenity.takeScreenshot();
	}
	
	public void seleccionarContinuar() {
    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.btnContinuar,0);
    }
	
	void seleccionarFechaCalendario(String fecha) {
		String[] calendario = fecha.split("-");		
		ConstantesUtil.setNombreMes(calendario[1]);
		
		pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboAnioNacimiento, calendario[2]);
    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboMesNacimiento, ConstantesUtil.mesAbreviado);
    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.lblDia(Integer.parseInt(calendario[0])), 0);    	
	}

	public void ingresarDatosPersonalesExpedition(String tipoPasajero, int nroPasajero) {
		
		if(pageObjectUtil.seleniumEsVisible(getDriver(), xpathDatosPersonales.txtPrimerNombreExp(nroPasajero),0)==false) {
			pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.lstPasajeroxCabinaExp(nroPasajero), 0);	
		}
    	
    	if(tipoPasajero.compareTo("ADULT")==0) {
    		cont_Adultos++;
    		
    		String anoNacAdulto=ConstantesUtil.fecNacimientoAdulto.split("-")[2];
	    	ConstantesUtil.setNombreMes(ConstantesUtil.fecNacimientoNino.split("-")[1]);
	    	String diaNacAdulto=ConstantesUtil.fecNacimientoAdulto.split("-")[0];
	    	
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtPrimerNombreExp(nroPasajero), 0, ConstantesUtil.nomAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtApellidoExp(nroPasajero), 0, ConstantesUtil.apeAdulto);
	    	pageObjectUtil.sleep(2);
	    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtFechaNacimientoExp(nroPasajero), 0);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.lstAnoNacExp, anoNacAdulto);
	     	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.lstMesNacExp, ConstantesUtil.mesCompleto.toUpperCase());
	       	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtDiaNacimientoExp(Integer.parseInt(diaNacAdulto)),0);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboNacionalidadExp(nroPasajero),ConstantesUtil.nacionalidadAdulto);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboTipoDocumentoExp(nroPasajero),ConstantesUtil.tipoDocumentoAdulto); 
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtNroDocumentoExp(nroPasajero), 0, String.valueOf(10000000 + new Random().nextInt(90000000)));
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboSexoExp(nroPasajero),ConstantesUtil.sexoAdulto); 
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtTelefonoExp(nroPasajero), 0, ConstantesUtil.telefonoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtCorreoExp(nroPasajero), 0, ConstantesUtil.correoAdulto);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtCorreoConfirmacionExp(nroPasajero), 0, ConstantesUtil.correoAdulto);
	   	
    	}else {
    		String anoNacNino=ConstantesUtil.fecNacimientoNino.split("-")[2];
	    	
	    	ConstantesUtil.setNombreMes(ConstantesUtil.fecNacimientoNino.split("-")[1]);
	    	
	    	String diaNacNino=ConstantesUtil.fecNacimientoNino.split("-")[0];
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtPrimerNombreExp(nroPasajero), 0, ConstantesUtil.nomNino);
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtApellidoExp(nroPasajero), 0, ConstantesUtil.apeNino);
	    	pageObjectUtil.sleep(2);
	    	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtFechaNacimientoExp(nroPasajero), 0);
	     	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.lstAnoNacExp, anoNacNino);     	
	     	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.lstMesNacExp, ConstantesUtil.mesCompleto.toUpperCase());
	     	pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.txtDiaNacimientoExp(Integer.parseInt(diaNacNino)),0);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboNacionalidadExp(nroPasajero),ConstantesUtil.nacionalidadNino);
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboTipoDocumentoExp(nroPasajero),ConstantesUtil.tipoDocumentoNino); 
	    	pageObjectUtil.seleniumEscribir(getDriver(), xpathDatosPersonales.txtNroDocumentoExp(nroPasajero), 0, String.valueOf(10000000 + new Random().nextInt(90000000)));
	    	pageObjectUtil.seleniumSelectCombo(getDriver(), xpathDatosPersonales.cboSexoExp(nroPasajero),ConstantesUtil.sexNino); 
    	}
		
    	Serenity.takeScreenshot();
	}

	public void seleccionarContinuarExp() {
		pageObjectUtil.seleniumClick(getDriver(), xpathDatosPersonales.btnContinuarExp,0);
	}

}
