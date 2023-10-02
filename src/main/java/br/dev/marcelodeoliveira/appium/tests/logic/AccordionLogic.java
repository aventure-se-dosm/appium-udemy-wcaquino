package br.dev.marcelodeoliveira.appium.tests.logic;

import org.junit.Before;

import br.dev.marcelodeoliveira.appium.tests.model.pages.AccordionPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;

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
