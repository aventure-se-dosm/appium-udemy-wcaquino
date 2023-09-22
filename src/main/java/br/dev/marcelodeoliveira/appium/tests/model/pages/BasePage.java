package br.dev.marcelodeoliveira.appium.tests.model.pages;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

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

	public void tap(Integer x, Integer y) {

		new TouchAction<>(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	protected MobileElement getMobileElementByXpathAndTxt(String formatXpath, Object... value) {
		return getDriver().findElementByXPath(String.format(formatXpath, value));
	}

	protected MobileElement getElement(By by) {
		return getDriver().findElement(by);
	}

	protected boolean waitUntilWebElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}
	protected boolean waitUntilMobileElementToBeVisible(MobileElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}

	protected boolean waitUntilMobileElementListToBeVisible(List<MobileElement> listElement) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(
				listElement.stream().map(elem -> (MobileElement) elem).collect(Collectors.toList()))) != null;
	}

	protected boolean waitUntilMobileElementToBeInvisible(MobileElement element) {
		try {
			if (!element.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException exp) {
			return true;
		}
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void writeText(MobileElement element, Object text) {
		waitUntilWebElementToBeVisible(element);
		element.sendKeys(text.toString());
	}

	protected String getText(MobileElement element) {
		waitUntilWebElementToBeVisible(element);
		return element.getText();
	}

	protected boolean isElementSelected(MobileElement elem) {
		return elem.isSelected();
	}

	public void changeElementState(MobileElement element, boolean status) {
		waitUntilWebElementToBeVisible(element);
		if (isElementChecked(element) != status) {
			click(element);
		}
	}

	public String getAttribute(MobileElement element, String attrubute) {
		waitUntilWebElementToBeVisible(element);
		return element.getAttribute(attrubute);
	}

	public boolean isElementChecked(MobileElement element) {
		waitUntilWebElementToBeVisible(element);
		String s = element.getAttribute("checked");
		boolean b = Boolean.parseBoolean(s);
		return b;
	}

	protected boolean isElementVisible(MobileElement element) {
		return element.isDisplayed();
	}

	protected void clickByText(String param, String value) {
		click(getElement(MobileBy.xpath(String.format(param + "[@text='%s']", value))));
	}

	public List<WebElement> getMobileElements(By by) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	public String getAssertionMessage(Object expectedValue, Object actualValue) {
		return String.format("expected: %s,  actual: %s", expectedValue.toString(), actualValue.toString());
	}
	
	//***********************************Screen and Element Utils*************************************************

	protected int getElementInteractableXAxisRange(MobileElement element) {
		return getElementCenter(element).getX();
		//return getLocation(element).getX();
	}
	
	protected int getElementInteractableYAxisRange(MobileElement element) {
		return getElementCenter(element).getY();
		//return getLocation(element).getY();
	}
	
	protected Point getLocation (MobileElement element) {
		return element.getLocation();
	}

	protected Point getElementCenter(MobileElement element) {
		return element.getCenter();
	}
	
	
	protected int getHeight(WebElement element) {
		return element.getRect().getHeight();
	}

	protected int getWidth(WebElement element) {
		return element.getRect().getWidth();
	}

	private int getRectX(WebElement element) {
		return element.getRect().getX();
	}

	private int getRectY(WebElement element) {
		return element.getRect().getY();
	}
	
	public Point getSlidInteractableXbyPercentage(MobileElement slid, Integer percents) {
		return new Point(getMaximumX(slid)*percentageOf(percents).intValue(), getElementInteractableYAxisRange(slid));
	}

	private Float percentageOf(Integer percents) {
		return percents/100f;
	}

	private int getMaximumX(MobileElement slid) {
		return getLocation(slid).getX()+getWidth(slid);
	}
}
