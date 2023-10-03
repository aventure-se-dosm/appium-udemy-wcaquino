package br.dev.marcelodeoliveira.appium.tests.logic;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public abstract class BaseLogic {

	protected WebDriverWait wait;
	protected final Integer NO_WAIT = 0;
	protected final Integer LONG_CLICK_WAIT = 1000;
	protected static final Float MIN_AXIS_MOVING_VALUE = 0.1F;
	protected static final Float MAX_AXIS_MOVING_VALUE = 0.9F;

	public BaseLogic() {
		wait = new WebDriverWait(getDriver(), 15l);
		setupPages();
	}

	@Before
	protected abstract void setupPages(BasePage... pages);

	protected void click(WebElement element) {
		waitUntilWebElementToBeVisibleAndItsNotNullForClick(element);
		element.click();
	}

	private void waitUntilWebElementToBeVisibleAndItsNotNullForClick(WebElement element) {
		wait.withTimeout(Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOf(element));
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

	Point getWindowCenter() {
		return new Point(getWindowWidth() / 2, getWindowHeight() / 2);
	}

	protected void scroll(Float pctInicio, Float pctFim) {
		int x = getWindowCenter().getX();
		int startY = (int) (getWindowHeight() * pctInicio);
		int endY = (int) (getWindowHeight() * pctFim);

		new TouchAction<>(getDriver()).press(PointOption.point(new Point(x, startY)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(new Point(x, endY))).release().perform();
	}

	protected void scrollUp(Float pctInicio, Float pctFim) {
		if (pctInicio < pctFim) {
			scroll(pctInicio, pctFim);
		} else {
			scroll(pctFim, pctInicio);
		}
	}

	protected void scrollDown(Float pctInicio, Float pctFim) {
		if (pctInicio > pctFim) {
			scroll(pctInicio, pctFim);
		} else {
			scroll(pctFim, pctInicio);
		}
	}

	protected void scrollDown() {
		scrollDown(MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	protected void scrollUp() {
		scrollUp(MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	protected void swipe(Float pctInicio, Float pctFim) {

		swipe(getDefaultPoint().getY(), pctInicio, pctFim);
		int y = getWindowCenter().getY();
		int startX = (int) (getWindowWidth() * pctInicio);
		int endX = (int) (getWindowWidth() * pctFim);

		new TouchAction<>(getDriver()).press(PointOption.point(new Point(startX, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(endX, y))).release().perform();
	}

	protected void swipe(Integer middleY, Float pctInicio, Float pctFim) {
		int y = middleY;
		int startX = (int) (getWindowWidth() * pctInicio);
		int endX = (int) (getWindowWidth() * pctFim);

		new TouchAction<>(getDriver()).press(PointOption.point(new Point(startX, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(endX, y))).release().perform();
	}

	protected void swipeLeft(Float pctInicio, Float pctFim) {
		if (pctInicio > pctFim) {
			swipe(pctInicio, pctFim);
		} else {
			swipe(pctFim, pctInicio);
		}
	}

	public void swipeRight(Float pctInicio, Float pctFim) {
		swipeRight(getDefaultPoint().getY(), pctInicio, pctFim);
	}

	protected void swipeLeft(Integer y, Float pctInicio, Float pctFim) {
		if (pctInicio > pctFim) {
			swipe(y, pctInicio, pctFim);
		} else {
			swipe(y, pctFim, pctInicio);
		}
	}

	private Point getDefaultPoint() {
		return getWindowCenter();
	}

	public void swipeRight(Integer y, Float pctInicio, Float pctFim) {
		if (pctInicio < pctFim) {
			swipe(y, pctInicio, pctFim);
		} else {
			swipe(y, pctFim, pctInicio);
		}
	}

	protected void scrollToElement(WebElement element) {
		int WindowHeight = getWindowHeight();
		Assert.assertEquals(WindowHeight, 1794);
	}

	protected void longClick(Integer x, Integer y) {
		longClick(new Point(x, y));
	}

	protected MobileElement getMobileElementByXpathAndTxt(String formatXpath, Object... value) {
		return getDriver().findElementByXPath(String.format(formatXpath, value));
	}

	protected MobileElement getElement(By by) {
		return (MobileElement) waitUntilWebElementToBeVisible(by);
	}

	protected MobileElement getElement(MobileElement element) {
		return waitUntilElementToBeVisible(element);
	}

	protected boolean waitUntilWebElementToBeVisibleAndItsNotNull(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)) != null;
	}

	protected boolean waitUntilWebElementToBeVisibleAndItsNotNull(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)) != null;
	}

	protected WebElement waitUntilWebElementToBeVisible(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected WebElement waitUntilElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected MobileElement waitUntilElementToBeVisible(MobileElement element) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected List<WebElement> waitUntilElementListToBeVisible(List<WebElement> listAllTextView) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(listAllTextView));
	}

	protected boolean waitUntilElementListToBeVisibleAndNotNull(List<WebElement> listAllTextView) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(
				listAllTextView.stream().map(elem -> (MobileElement) elem).collect(Collectors.toList()))) != null;
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

	protected String getText(WebElement elem) {
		waitUntilWebElementToBeVisibleAndItsNotNull(elem);
		return elem.getText();
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

	protected int getElementInteractableXAxisRange(MobileElement element) {
		return getElementCenter(element).getX();

	}

	protected int getElementInteractableYAxisRange(MobileElement element) {
		return getElementCenter(element).getY();

	}

	protected Point getLocation(MobileElement element) {
		return element.getLocation();
	}

	protected Point getElementCenter(MobileElement element) {
		return waitUntilElementToBeVisible(element).getCenter();
	}

	protected Point getElementCenter(WebElement element) {
		return getElementCenter((MobileElement) element);
	}

	protected int getHeight(WebElement element) {
		return element.getRect().getHeight();
	}

	protected int getWidth(WebElement element) {
		return element.getRect().getWidth();
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

	public boolean isTextPresent(String txtValue) {
		return waitUntilWebElementToBeVisibleAndItsNotNull(By.xpath(String.format("//*[@text='%s']", txtValue)));
	}

	public void swipeRight() {
		swipeRight(getDefaultPoint().y, MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	public void swipeRight(Point point) {
		swipeRight(point.getY(), MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	public void swipeLeft() {
		swipeLeft(getDefaultPoint().y, MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	public void swipeLeft(Point point) {
		swipeLeft(point.getY(), MIN_AXIS_MOVING_VALUE, MAX_AXIS_MOVING_VALUE);
	}

	public void drag(WebElement origin, WebElement end) {

		new TouchAction<>(getDriver()).longPress(ElementOption.element(origin)).moveTo(ElementOption.element(end))
				.release().perform();
	}

	public List<WebElement> waitUntilElementListToBeVisible(WebElement... elements) {
		return waitUntilElementListToBeVisible(Arrays.asList(elements));
	}

}
