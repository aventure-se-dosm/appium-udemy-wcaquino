package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
	private MobileElement formulario;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash']")
	private MobileElement splash;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Abas']")
	private MobileElement abas;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Alertas']")
	private MobileElement alertas;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Accordion']")
	private MobileElement accordion;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cliques']")
	private MobileElement cliques;

	public MobileElement getFormulario() {
		return formulario;
	}

	private MobileElement getAbas() {
		return abas;
	}

	private WebElement getAccordion() {
		return accordion;
	}

	private WebElement getAlertas() {
		return alertas;
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

	public void clicaAbas() {
		click(getAbas());
	}

	public void clicaAlertas() {
		click(getAlertas());
	}

	public void clicaAccordion() {
		click(getAccordion());
	}

	public void clicaCliques() {
		// TODO Auto-generated method stub
		click(getCliques());
	}

	private WebElement getCliques() {
		// TODO Auto-generated method stub
		return cliques;
	}

}