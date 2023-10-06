package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.webview;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewPage extends BasePage {

	protected WebDriverWait wait;

	public WebViewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 15L);
	}

	@FindBy(xpath = "//*[@resource-id='android:id/button1']")
	private WebElement okPopUp;

	@FindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/continue_button']")
	private WebElement btnContinue;

	@FindBy(id = "email")
	private WebElement txtEmail;

	@FindBy(id = "senha")
	private WebElement txtSenha;

	@FindBy(xpath = "//*[text()='Entrar']")
	private WebElement btnEntrar;

	public WebDriverWait getWait() {
		return wait;
	}

	public WebElement getOkPopUp() {
		return okPopUp;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtSenha() {
		return txtSenha;
	}

	public WebElement getBtnEntrar() {
		return btnEntrar;
	}

}
