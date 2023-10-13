package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import org.junit.Before;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.AccordionPage;

public class AccordionLogic extends BaseLogic {

	private AccordionPage page;

	public String getTxtOpcao1Txt() {
		return getText(page.getTxtOpcao1());
	}

	public void getSelectOption1() {
		click(page.getBtnOpcao1());
	}

	public String getAccordion1Text() {
		return getText(page.getTxtOpcao1());
	}

	@Override
	@Before
	protected void setupPages(BasePage... pages) {
		this.page = new AccordionPage();
	}

}
