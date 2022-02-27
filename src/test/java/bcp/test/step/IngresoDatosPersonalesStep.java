package bcp.test.step;

import bcp.test.pages.AppDatosPasajeros;
import bcp.test.util.VariablesUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class IngresoDatosPersonalesStep {

	@Steps
	private AppDatosPasajeros appDatosPasajeros;

	@Step
	public void ingresoDatosPasajerosBelmond(String v_grupoAdultos, String v_grupoNinos, String tipoCabina, int nroCabinas) {
		String[] nroAdultosxCabina=v_grupoAdultos.split("-");
		String[] nroNinosxCabina=v_grupoNinos.split("-");
		
		for(int contCabinas=0; contCabinas<VariablesUtil.v_nroCabinas; contCabinas++) {
			if(nroAdultosxCabina[contCabinas].compareTo("0")!=0)
				appDatosPasajeros.ingresarDatosPersonales("ADULTO", contCabinas+1, nroAdultosxCabina[contCabinas], 1); //1 - Adulto
			if(nroNinosxCabina[contCabinas].compareTo("0")!=0)
				appDatosPasajeros.ingresarDatosPersonales("NINO", contCabinas+1, nroNinosxCabina[contCabinas], 2);// 2- Niño
		}
		appDatosPasajeros.seleccionarContinuar();
	}

	@Step
	public void ingresoDatosPasajerosExpedition(int nroAdultosExpedition, int nroNinosExpedition) {
		int cont_Pasajeros=1;
		
		for(int i=1; i<=nroAdultosExpedition;i++) {
			appDatosPasajeros.ingresarDatosPersonalesExpedition("ADULT",cont_Pasajeros);
			cont_Pasajeros++;
		}
		
		for(int i=0; i<nroNinosExpedition;i++) {
			appDatosPasajeros.ingresarDatosPersonalesExpedition("CHILD",cont_Pasajeros);
			cont_Pasajeros++;
		}
		appDatosPasajeros.seleccionarContinuarExp();
	}
	
}
