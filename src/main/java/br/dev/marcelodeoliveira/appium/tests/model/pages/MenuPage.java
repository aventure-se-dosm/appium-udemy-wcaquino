package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
	private MobileElement formulario;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash']")
	private MobileElement splash;

	public MobileElement getFormulario() {
		return formulario;
	}

	public MobileElement getSplash() {
		return splash;
	}

	public void clicaFormulario() {
		click(getFormulario());
	}

	public void clicaSplash() {
		click(getSplash());
	}

	public boolean isMenuVisible() {
		return isElementVisible(getFormulario());
	}

}