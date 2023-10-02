package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class SwipeListPage extends BasePage {

	public String getSwipeBarXpathByIndex(String index) {
		return String.format("//android.widget.TextView[contains(@text, 'Opção %s')]", index);
	}

	public String getOptionSignalFrame(String index, String signal) {
		return String.format(
				"//android.widget.TextView[contains(@text, 'Opção %s')]/../../following-sibling::*//*[@text='%s']",
				index, signal);
	}

	public MobileElement getOptElelmByXpath(String index) {

		return getElement(By.xpath(getSwipeBarXpathByIndex(index)));
	}

	public String getSwipeBarText(String index) {
		return getText(getElement(By.xpath(getSwipeBarXpathByIndex(index))));
	}

}
