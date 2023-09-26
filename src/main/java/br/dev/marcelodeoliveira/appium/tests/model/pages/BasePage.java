package br.dev.marcelodeoliveira.appium.tests.model.pages;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public abstract class BasePage {

	WebDriverWait wait;
	private final Integer NO_WAIT = 0;
	private final Integer LONG_CLICK_WAIT = 1000;

	public BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 10L);
	}

	protected void click(WebElement element) {
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
		element.click();
	}

	public void tap(Integer x, Integer y) {

		new TouchAction<>(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void tap(Point p) {

		new TouchAction<>(getDriver()).tap(PointOption.point(p)).perform();
	}

	public Integer getWindowWidth() {
		return getWindowDimension().width;
	}

	public Integer getWindowHeight() {
		return getWindowDimension().height;
	}

	public Dimension getWindowDimension() {
		return getDriver().manage().window().getSize();
	}

	public void scroll(Double pctInicio, Double pctFim) {
		int x = getWindowWidth() / 2;
		int startY = (int) (getWindowHeight() * pctInicio);
		int endY = (int) (getWindowHeight() * pctFim);

		new TouchAction<>(getDriver()).press(PointOption.point(new Point(x, startY)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(new Point(x, endY))).release().perform();
	}

	protected void swipe(Double pctInicio, Double pctFim, WebElement element) {
		new TouchAction<>(getDriver())
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
				// TODO
				.moveTo(PointOption.point(0, 0)).release().perform();
	}

	protected void scrollToElement(WebElement element) {
		int WindowHeight = getWindowHeight();
		Assert.assertEquals(WindowHeight, 1794);
	}

	protected void longClick(Integer x, Integer y) {
		longClick(new Point(x, y));
//		new TouchAction<>(getDriver()).longPress(PointOption.point(x, y))
//				// .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//				.release().perform();
	}

	protected MobileElement getMobileElementByXpathAndTxt(String formatXpath, Object... value) {
		return getDriver().findElementByXPath(String.format(formatXpath, value));
	}

	protected MobileElement getElement(By by) {
		return getDriver().findElement(by);
	}

	protected MobileElement getElement(MobileElement element) {
		return waitUntilElementToBeVisible(element);
	}

	protected boolean waitUntilWebElementToBeVisibleAndItsNotNull(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}

	protected WebElement waitUntilElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected MobileElement waitUntilElementToBeVisible(MobileElement element) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected boolean waitUntilElementListToBeVisible(List<MobileElement> listElement) {
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
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
		element.sendKeys(text.toString());
	}

	protected String getText(MobileElement element) {
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
		return element.getText();
	}

	protected boolean isElementSelected(MobileElement elem) {
		return elem.isSelected();
	}

	public void changeElementState(MobileElement element, boolean status) {
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
		if (isElementChecked(element) != status) {
			click(element);
		}
	}

	public String getAttribute(MobileElement element, String attrubute) {
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
		return element.getAttribute(attrubute);
	}

	public boolean isElementChecked(MobileElement element) {
		waitUntilWebElementToBeVisibleAndItsNotNull(element);
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

	// ***********************************Screen and Element
	// Utils*************************************************

	protected int getElementInteractableXAxisRange(MobileElement element) {
		return getElementCenter(element).getX();
		// return getLocation(element).getX();
	}

	protected int getElementInteractableYAxisRange(MobileElement element) {
		return getElementCenter(element).getY();
		// return getLocation(element).getY();
	}

	protected Point getLocation(MobileElement element) {
		return element.getLocation();
	}

	protected Point getElementCenter(MobileElement element) {
		return waitUntilElementToBeVisible(element).getCenter();
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
		return new Point(getMaximumX(slid) * percentageOf(percents).intValue(), getElementInteractableYAxisRange(slid));
	}

	private Float percentageOf(Integer percents) {
		return percents / 100f;
	}

	private int getMaximumX(MobileElement slid) {
		return getLocation(slid).getX() + getWidth(slid);
	}

	public WebElement getNestedElement(MobileElement element, By by) {
		return waitUntilElementToBeVisible(element.findElement(by));
	}

	public void longClick(Point center) {
		new TouchAction<>(getDriver()).longPress(PointOption.point(center)).release().perform();

	}

	public void doubleClick(Point elementCenter, Integer millisWaitDuration) {
		new TouchAction<>(getDriver()).tap(PointOption.point(elementCenter)).release().perform();
		new TouchAction<>(getDriver()).waitAction(WaitOptions.waitOptions(Duration.ofMillis(millisWaitDuration)))
				.perform();
		new TouchAction<>(getDriver()).tap(PointOption.point(elementCenter)).release().perform();

	}

	public void doubleClick(Point elementCenter) {
		doubleClick(elementCenter, NO_WAIT);
	}

	public void slowDoubleClick(Point elementCenter) {
		doubleClick(elementCenter, LONG_CLICK_WAIT);
	}

	public void clickByPoint(Point point) {
		tap(point);
	}
}
