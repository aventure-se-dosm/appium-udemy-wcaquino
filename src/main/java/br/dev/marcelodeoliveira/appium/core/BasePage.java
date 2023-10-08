package br.dev.marcelodeoliveira.appium.core;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {

	protected WebDriverWait wait;
	protected final Integer NO_WAIT = 0;
	protected final Integer LONG_CLICK_WAIT = 1000;
	protected static final Float MIN_AXIS_MOVING_VALUE = 0.1F;
	protected static final Float MAX_AXIS_MOVING_VALUE = 0.9F;

	public BasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 10L);
	}

	public String getElementByXpathPattern(String xpathPattern, Object... values) {
		return String.format(xpathPattern, values);

	}

}
