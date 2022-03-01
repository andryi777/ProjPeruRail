package bcp.test.step;

import bcp.test.pages.AppTrenExpedition;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class SeleccionTrenJourneyStep {

	public static double montoIda=0;
	public static double montoVuelta=0;
	
	@Steps
	AppTrenExpedition appTrenExpedition =  new AppTrenExpedition();

	@Step
	public void seleccionoTren(String trenSalida, String trenRetorno) {

		appTrenExpedition.seleccionarResumenCompra();
		
		if(trenSalida.compareTo("No Aplica")!=0) {
			montoIda = appTrenExpedition.seleccionarTrainSalida(trenSalida);
		}
		
		if(trenRetorno.compareTo("No Aplica")!=0) {
			montoVuelta = appTrenExpedition.seleccionarTrainRegreso(trenRetorno);
		}
		
		appTrenExpedition.seleccionarContinuar();
			
	}

}
