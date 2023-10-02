package br.dev.marcelodeoliveira.appium.tests.logic;

import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuLogic extends BaseLogic {

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

	private MenuPage page;

	private MobileElement getAlertMessage() {
		return alertMessage;
	}

	private MobileElement getAlertTitle() {
		return alertTitle;
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

	private MobileElement getBtnOk() {
		return btnOk;
	}

	private WebElement getCliques() {
		return cliques;
	}

	private WebElement getDragAndDrop() {
		return this.dragAndDrop;
	}

	public MobileElement getFormulario() {
		return formulario;
	}

	private MobileElement getOpcaoEscondida() {
		return opcaoEscondida;
	}

	private WebElement getSeuBarrigaHibrido() {
		return seuBarrigaHibrido;
	}

	public MobileElement getSplash() {
		return splash;
	}

	private WebElement getSwipe() {
		return swipe;
	}

	private WebElement getSwipeList() {
		return swipeList;
	}

	public void clicaFormulario() {
		click(page.getFormulario());
	}

	public void clicaSplash() {
		click(page.getSplash());
	}

	public boolean isMenuVisible() {
		return isElementVisible(getFormulario());
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
		return getText(getAlertMessage());
	}

	public String getAlertTitleTxt() {
		return getText(getAlertTitle());
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