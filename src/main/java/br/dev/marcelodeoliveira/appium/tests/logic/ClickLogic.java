package br.dev.marcelodeoliveira.appium.tests.logic;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.ClickPage;

public class ClickLogic extends BaseLogic {

	private ClickPage page;

	public void cliqueLongo() {
		click(page.getBtnLimpar());
		longClick(getElementCenter(page.getBtnCliqueLongo()));
	}

	public String getDisplayContent() {
		return getText(page.getDisplay());
	}

	public void cliqueDuploRapido() {
		click(page.getBtnLimpar());
		doubleClick(getElementCenter(page.getBtnCliqueDuploRapido()));
	}

	public void cliqueDuploLento() {
		click(page.getBtnLimpar());
		doubleClick(getElementCenter(page.getBtnCliqueDuploLento()));
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new ClickPage();

	}

}
