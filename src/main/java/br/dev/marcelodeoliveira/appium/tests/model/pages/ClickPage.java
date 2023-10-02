package br.dev.marcelodeoliveira.appium.tests.model.pages;

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

	@AndroidFindBy(xpath = "//*[@text='Clique duplo']/following-sibling::*")
	private MobileElement display;

	public MobileElement getBtnCliqueLongo() {
		return btnCliqueLongo;
	}

	public MobileElement getBtnCliqueDuploRapido() {
		return btnCliqueDuploRapido;
	}

	public MobileElement getBtnCliqueDuploLento() {
		return btnCliqueDuploLento;
	}

	public MobileElement getBtnLimpar() {
		return btlLimpar;
	}

	public MobileElement getDisplay() {
		return display;
	}
//
//	public void cliqueLongo() {
//		click(getBtnLimpar());
//		longClick(getElementCenter(getBtnCliqueLongo()));
//	}
//
//	public String getDisplayContent() {
//		return getText(getDisplay());
//	}
//
//	public void cliqueDuploRapido() {
//		click(getBtnLimpar());
//		doubleClick(getElementCenter(getBtnCliqueDuploRapido()));
//	}
//
//	public void cliqueDuploLento() {
//		click(getBtnLimpar());
//		slowDoubleClick(getElementCenter(getBtnCliqueDuploLento()));
//	}

}
