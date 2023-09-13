package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.support.PageFactory;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;

public class BasePage {

	protected void pageInit(Class<? extends BasePage> pageClass) {
		PageFactory.initElements(DriverFactory.getDriver(), pageClass);
	}

	public BasePage() {
		//pageInit(this.getClass());
	}

}
