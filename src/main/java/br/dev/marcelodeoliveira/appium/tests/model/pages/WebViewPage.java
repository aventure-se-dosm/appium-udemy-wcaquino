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
	protected final Integer NO_WAIT = 0;
	protected final Integer LONG_CLICK_WAIT = 1000;
	protected static final Float MIN_AXIS_MOVING_VALUE = 0.1F;
	protected static final Float MAX_AXIS_MOVING_VALUE = 0.9F;

	public WebViewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 15L);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void switchToWebContext() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> contextSet = getDriver().getContextHandles();

		contextSet.stream().forEach(System.out::println);

		getDriver().context((String) contextSet.toArray()[1]);
	}

	public void setEmail(String email) {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switchToWebContext();
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
