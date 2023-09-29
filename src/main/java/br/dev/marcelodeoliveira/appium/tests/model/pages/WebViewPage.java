package br.dev.marcelodeoliveira.appium.tests.model.pages;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.*;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void switchToWebContext() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> contextSet = getDriver().getContextHandles();
		
		//visuzlize context
		contextSet.stream().forEach(System.out::println);
		
		//set context with index 1
		getDriver().context((String) contextSet.toArray()[1]);
	}
	
	public void setEmail(){
		
		//getDriver().context((String) getDriver().getContextHandles().toArray()[1]);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		switchToWebContext();
		WebElement txtEmail = getWebDriver().findElement(By.xpath("//*[@id='email']"));
		
		txtEmail.sendKeys("automation.mrkolv@gmail.com");
		
		WebElement txtSenha = getWebDriver().findElement(By.xpath("//*[@id='senha']"));
		
		txtSenha.sendKeys("123!");
		WebElement btnEntrar = getWebDriver().findElement(By.xpath("//*[text()='Entrar']"));
		
		btnEntrar.click();
		
	}
}
