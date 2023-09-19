package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.util.List;
import java.util.stream.Collectors;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {

	WebDriverWait wait;

	public BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 10L);
	}

	protected void click(WebElement element) {
		waitUntilWebElementToBeVisible(element);
		element.click();
	}
	

	
	
	protected MobileElement getMobileElementByXpathAndTxt(String formatXpath, Object ...value){
		return getDriver().findElementByXPath(String.format(formatXpath, value));
	}
	
	protected MobileElement getElement(By by){
		return getDriver().findElement(by);
	}

	protected boolean waitUntilWebElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}

	protected boolean waitUntilWebElementToBeInvisible(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void writeText(MobileElement element, String text) {
		waitUntilWebElementToBeVisible(element);
		element.sendKeys(text);
	}

	protected String getText(MobileElement element) {
		waitUntilWebElementToBeVisible(element);
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

	public boolean isElementVisible(MobileElement element) {
		return element.isDisplayed();
	}

	protected  void clickByText(String param, String value) {
		click(getElement(MobileBy.xpath(String.format(param+"[@text='%s']", value))));
	}

	public List<WebElement> getMobileElements(By by) {
		// TODO Auto-generated method stub
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	};
}
