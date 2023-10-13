package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page;

import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BasePage;
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe List']")
	private WebElement swipeList;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and drop']")
	private WebElement dragAndDrop;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Híbrido']")
	private WebElement seuBarrigaHibrido;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SeuBarriga Nativo']")
	private WebElement sbNativo;

	public MobileElement getAlertMessage() {
		return alertMessage;
	}

	public MobileElement getAlertTitle() {
		return alertTitle;
	}

	public MobileElement getAbas() {
		return abas;
	}

	public WebElement getAccordion() {
		return accordion;
	}

	public WebElement getAlertas() {
		return alertas;
	}

	public MobileElement getBtnOk() {
		return btnOk;
	}

	public WebElement getCliques() {
		return cliques;
	}

	public WebElement getDragAndDrop() {
		return this.dragAndDrop;
	}

	public MobileElement getFormulario() {
		return formulario;
	}
	public MobileElement getTailElement() {
		return getFormulario();
	}

	public MobileElement getOpcaoEscondida() {
		return opcaoEscondida;
	}

	public WebElement getSeuBarrigaHibrido() {
		return seuBarrigaHibrido;
	}

	public MobileElement getSplash() {
		return splash;
	}

	public WebElement getSwipe() {
		return swipe;
	}

	public WebElement getSwipeList() {
		return swipeList;
	}

	public WebElement getSBNativo() {
		return sbNativo;
	}

}