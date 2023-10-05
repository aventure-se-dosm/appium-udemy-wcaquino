package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash!']")
	private MobileElement txtSplash;

	public MobileElement getTxtSplash() {
		return txtSplash;
	}
}
