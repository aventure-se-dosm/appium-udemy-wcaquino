package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.steps;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.AccordionLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;

public class AccordionSteps {
	private AccordionLogic accordionLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveIteragirComAccordionOpcao1() {
		menuLogic.clicaAccordion();
		accordionLogic.getSelectOption1();
		Assert.assertEquals("Esta é a descrição da opção 1", accordionLogic.getTxtOpcao1Txt());

	}


}
