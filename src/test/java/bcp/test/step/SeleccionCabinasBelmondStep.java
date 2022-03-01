package bcp.test.step;

import javax.swing.JOptionPane;

import bcp.test.pages.AppCabinasBelmond;
import bcp.test.util.VariablesUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class SeleccionCabinasBelmondStep {
	
	@Steps
	private AppCabinasBelmond appCabinasBelmond;
	
	@Step
	public void seleccionoCabina(String tipoCabina, String nroCabinas) {
		appCabinasBelmond.seleccionarNroCabinas(tipoCabina, nroCabinas);
	}

	@Step
	public void seleccionoNroPasajeros(String grupoAdultos, String grupoNinos, String tipoCabina, int nroCabinas) {
		String[] nroAdultosxCabina=grupoAdultos.split("-");
		String[] nroNinosxCabina=grupoNinos.split("-");
		
		for(int i=0; i<nroAdultosxCabina.length; i++) {			
			appCabinasBelmond.seleccionarNroPasajeros(tipoCabina, nroCabinas, nroAdultosxCabina[i], 1);//1 - Adulto
		}
		
		for(int i=0; i<nroNinosxCabina.length; i++) {
			appCabinasBelmond.seleccionarNroPasajeros(tipoCabina, nroCabinas, nroNinosxCabina[i], 2);//2 - Niño
		}		
		appCabinasBelmond.seleccionarContinuar();
	}

	@Step
	public String getMensajeMin1Adulto() {
		return appCabinasBelmond.mensajeValidacion1Adulto();
	}


}
