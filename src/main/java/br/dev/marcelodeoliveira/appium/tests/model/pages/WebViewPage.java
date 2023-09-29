package br.dev.marcelodeoliveira.appium.tests.model.pages;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getWebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewPage {

	protected WebDriverWait wait;

	public WebViewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 15L);
		permissionContinue();
		clickOkPopUp();
	}

	private void clickOkPopUp() {
		getDriver().findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
	}

	private void permissionContinue() {
		getDriver().findElement(By.xpath("//*[@resource-id='com.android.permissioncontroller:id/continue_button']"))
				.click();
	}

	public void switchToWebContext() {
		Set<String> contextSet = getDriver().getContextHandles();
		contextSet.stream().forEach(System.out::println);
		getDriver().context((String) contextSet.toArray()[1]);
	}

	public void setEmail(String email) {
		WebElement txtEmail = getWebDriver().findElement(By.xpath("//*[@id='email']"));
		txtEmail.sendKeys(email);
	}

	public void setSenha(String senha) {
		WebElement txtSenha = getWebDriver().findElement(By.xpath("//*[@id='senha']"));
		txtSenha.sendKeys(senha);
	}

	public void entrar() {
		WebElement btnEntrar = getWebDriver().findElement(By.xpath("//*[text()='Entrar']"));
		btnEntrar.click();
	}

	public String getWelcomeLabel() {
		WebElement lblAlerta = getWebDriver().findElement(By.xpath("//*[@role='alert']"));
		return lblAlerta.getText();
	}
}
