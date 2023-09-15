package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {

	WebDriverWait wait;
	
	public BasePage() {
	PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
	wait = new WebDriverWait(DriverFactory.getDriver(), 10L);
}
	

	protected void click(WebElement element) {
		waitUntilWebElementToBeVisible(element);
		element.click();
	}

	protected void waitUntilWebElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void writeText(MobileElement element, String text) {
		waitUntilWebElementToBeVisible(element);
		element.sendKeys(text);
	}

	protected String getText(MobileElement element) {
		return element.getText();
	}

	protected boolean isElementSelected(MobileElement elem) {
		return elem.isSelected();
	}

	public void changeElementState(MobileElement element, boolean status) {
		if (isElementChecked(element) != status) {
			click(element);
		}
	}

	public String getAttribute(MobileElement element, String attrubute) {
		return element.getAttribute(attrubute);
	}

	public boolean isElementChecked(MobileElement element) {
		waitUntilWebElementToBeVisible(element);
		String s = element.getAttribute("checked");
		boolean b = Boolean.parseBoolean(s);
		return b;
	}
}
