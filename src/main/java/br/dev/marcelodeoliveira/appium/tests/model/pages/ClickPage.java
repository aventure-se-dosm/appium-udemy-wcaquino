package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ClickPage extends BasePage {

	@AndroidFindBy(xpath = "//*[@text='Clique Longo']")
	private MobileElement btnCliqueLongo;

	@AndroidFindBy(xpath = "//*[@text='Clique duplo']")
	private MobileElement btnCliqueDuploRapido;

	@AndroidFindBy(xpath = "//*[@text='Clique duplo lento']")
	private MobileElement btnCliqueDuploLento;

	@AndroidFindBy(xpath = "//*[@text='Limpar']")
	private MobileElement btlLimpar;

	private MobileElement getBtnCliqueLongo() {
		return btnCliqueLongo;
	}

	private MobileElement getBtnCliqueDuploRapido() {
		return getElement(btnCliqueDuploRapido);
	}

	private MobileElement getBtnCliqueDuploLento() {
		return btnCliqueDuploLento;
	}

	private MobileElement getBtnLimpar() {
		return btlLimpar;
	}

	private MobileElement getDisplay() {
		return getElement(By.xpath("//*[@text='Clique duplo']/following-sibling::*"));
	}

	public void cliqueLongo() {
		click(getBtnLimpar());
		longClick(getElementCenter(getBtnCliqueLongo()));
	}

	public String getDisplayContent() {
		return getText(getDisplay());
	}

	public void cliqueDuploRapido() {
		click(getBtnLimpar());
		doubleClick(getElementCenter(getBtnCliqueDuploRapido()));
	}
	public void cliqueDuploLento() {
		click(getBtnLimpar());
		slowDoubleClick(getElementCenter(getBtnCliqueDuploLento()));
	}

}
