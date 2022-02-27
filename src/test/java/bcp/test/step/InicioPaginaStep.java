package bcp.test.step;

import bcp.test.pages.AppPeruRail;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class InicioPaginaStep {
	
	@Steps
	private AppPeruRail appPeruRail;

	@Step
	public void ingresarPeruRail() {
		appPeruRail.inicializar();

	}

}
