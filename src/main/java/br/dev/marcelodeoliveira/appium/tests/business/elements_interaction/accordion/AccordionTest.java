package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.accordion;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.menu.MenuLogic;

public class AccordionTest extends CTAppiumBaseTestVersionable {
	private AccordionLogic accordionLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveIteragirComAccordionOpcao1() {
		menuLogic.clicaAccordion();
		accordionLogic.getSelectOption1();
		Assert.assertEquals("Esta é a descrição da opção 1", accordionLogic.getTxtOpcao1Txt());

	}

	@Override
	protected void setupBaseLogic() {
		this.accordionLogic = new AccordionLogic();
		this.menuLogic = new MenuLogic();
	}

}