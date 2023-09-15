package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;

public class BasePage {

	BasePage() {
	}

	protected void click(MobileElement element) {
		element.click();
	}

	protected void writeText(MobileElement element, String text) {
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
		String s = element.getAttribute("checked");
		boolean b = Boolean.parseBoolean(s);
		return b;
	}
}
