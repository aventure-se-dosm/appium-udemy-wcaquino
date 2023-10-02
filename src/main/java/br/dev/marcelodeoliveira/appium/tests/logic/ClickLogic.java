package br.dev.marcelodeoliveira.appium.tests.logic;

import org.openqa.selenium.By;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.ClickPage;
import io.appium.java_client.MobileElement;

public class ClickLogic extends BaseLogic {

	private ClickPage page;

	private MobileElement getDisplay() {
		return getElement(By.xpath("//*[@text='Clique duplo']/following-sibling::*"));
	}

	public void cliqueLongo() {
		click(page.getBtnLimpar());
		longClick(page.getElementCenter(page.getBtnCliqueLongo()));
	}

	public String getDisplayContent() {
		return getText(getDisplay());
	}

	public void cliqueDuploRapido() {
		click(page.getBtnLimpar());
		doubleClick(page.getElementCenter(page.getBtnCliqueDuploRapido()));
	}

	public void cliqueDuploLento() {
		click(page.getBtnLimpar());
		doubleClick(page.getElementCenter(page.getBtnCliqueDuploLento()));
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new ClickPage();

	}

}
