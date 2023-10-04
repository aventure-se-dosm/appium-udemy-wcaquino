package br.dev.marcelodeoliveira.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.AccordionLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;

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
	protected void setupLogic() {
		this.accordionLogic = new AccordionLogic();
		this.menuLogic = new MenuLogic();
		
	}

}
