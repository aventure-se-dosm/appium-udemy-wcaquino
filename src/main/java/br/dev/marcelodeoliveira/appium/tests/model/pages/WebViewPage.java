package br.dev.marcelodeoliveira.appium.tests.model.pages;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewPage extends BasePage {

	protected WebDriverWait wait;

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

	public WebViewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 15L);
//		permissionContinue();
//		clickOkPopUp();
	}

//	private void clickOkPopUp() {
//		click(getOkPopUp());
//		// getDriver().findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
//	}
//
//	private void permissionContinue() {
//		click(getBtnContinue());
////		getDriver().findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']"))
////				.click();
//	}
//
//	public void switchToWebContext() {
//		Set<String> contextSet = getDriver().getContextHandles();
//		contextSet.stream().forEach(System.out::println);
//		getDriver().context((String) contextSet.toArray()[1]);
//	}
//
//	public void setEmail(String email) {
//		WebElement txtEmail = getWebDriver().findElement(By.xpath("//*[@id='email']"));
//		txtEmail.sendKeys(email);
//	}
//
//	public void setSenha(String senha) {
//		WebElement txtSenha = getWebDriver().findElement(By.xpath("//*[@id='senha']"));
//		txtSenha.sendKeys(senha);
//	}
//
//	public void entrar() {
//		WebElement btnEntrar = getWebDriver().findElement(By.xpath("//*[text()='Entrar']"));
//		btnEntrar.click();
//	}
//
//	public String getWelcomeLabel() {
//		WebElement lblAlerta = getWebDriver().findElement(By.xpath("//*[@role='alert']"));
//		return lblAlerta.getText();
//	}
}
