package br.dev.marcelodeoliveira.appium.tests.webview;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getWebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;

public class WebViewLogic extends BaseLogic {

	protected WebDriverWait wait;

	public void switchToWebContext() {
		Set<String> contextSet = getDriver().getContextHandles();
		contextSet.stream().forEach(System.out::println);
		getDriver().context((String) getDriver().getContextHandles().toArray()[1]);
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

	@Override
	protected void setupPages(BasePage... pages) {
		;
	}
}
