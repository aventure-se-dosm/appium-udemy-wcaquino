package br.dev.marcelodeoliveira.appium.tests.logic;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;

public class MenuLogic extends BaseLogic {
	private MenuPage page;

	public void clicaFormulario() {
		click(page.getFormulario());
	}

	public void clicaSplash() {
		click(page.getSplash());
	}

	public boolean isMenuVisible() {
		return isElementVisible(page.getFormulario());
	}

	public void clicaAbas() {
		click(page.getAbas());
	}

	public void clicaAlertas() {
		click(page.getAlertas());
	}

	public void clicaAccordion() {
		click(page.getAccordion());
	}

	public void clicaCliques() {
		click(page.getCliques());
	}

	public void clicaOpcaoEscondida() {
		waitUntilWebElementToBeVisibleAndItsNotNull(page.getFormulario());
		scrollDown();
		click(page.getOpcaoEscondida());
	}

	public String getAlertMessageTxt() {
		return getText(page.getAlertMessage());
	}

	public String getAlertTitleTxt() {
		return getText(page.getAlertTitle());
	}

	public void clicaAlertOk() {
		click(page.getBtnOk());
	}

	public void clickSwipe() {
		click(page.getSwipe());
	}

	public void clicaSwipeList() {
		scrollDown();
		click(page.getSwipeList());
	}

	public void clicaDragAndDrop() {
		waitUntilElementListToBeVisible(page.getFormulario());
		scrollDown();
		click(page.getDragAndDrop());
	}

	public void acessarSeuBarrigaHibrido() {
		click(page.getSeuBarrigaHibrido());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new MenuPage();
	}
}