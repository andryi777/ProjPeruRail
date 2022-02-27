package bcp.test.step;

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
			if(nroAdultosxCabina[i].compareTo("0")!=0)
				appCabinasBelmond.seleccionarNroPasajeros(tipoCabina, nroCabinas, nroAdultosxCabina[i], 1);
		}
		
		for(int i=0; i<nroNinosxCabina.length; i++) {
			if(nroNinosxCabina[i].compareTo("0")!=0)
				appCabinasBelmond.seleccionarNroPasajeros(tipoCabina, nroCabinas, nroNinosxCabina[i], 2);

		}
		
		appCabinasBelmond.seleccionarContinuar();
	}


}
