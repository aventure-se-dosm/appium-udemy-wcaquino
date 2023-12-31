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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement alertMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
	private MobileElement alertTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Opção bem escondida']")
	private MobileElement opcaoEscondida;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private MobileElement btnOk;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe']")
	private MobileElement swipe;

	private MobileElement getAlertMessage() {
		return alertMessage;
	}

	private MobileElement getAlertTitle() {
		return alertTitle;
	}

	private MobileElement getBtnOk() {
		return btnOk;
	}

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
	
	private WebElement getCliques() {
		return cliques;
	}

	private MobileElement getOpcaoEscondida() {
		return opcaoEscondida;
	}
	public MobileElement getSplash() {
		return splash;
	}

	private WebElement getSwipe() {
		return swipe;
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
		click(getCliques());
	}
	public void clicaOpcaoEscondida() {
		waitUntilWebElementToBeVisibleAndItsNotNull(getFormulario());
		scroll(0.9f, 0.2f);
		click(getOpcaoEscondida());
	}

	public String getAlertMessageTxt() {
		return getText(getAlertMessage());
	}
	public String getAlertTitleTxt() {
		return getText(getAlertTitle());
	}

	public void clicaAlertOk() {
		click(getBtnOk());
	}

	public void clickSwipe() {
		click(getSwipe());	
	}

	

}