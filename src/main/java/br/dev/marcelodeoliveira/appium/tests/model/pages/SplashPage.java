package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.TimeoutException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash!']")
	private MobileElement txtSplash;

	public MobileElement getTxtSplash() {
		return txtSplash;
	}

	public Object getSplashText() {
		return getTxtSplash().getText();
	}

	public boolean isSplashExibido() {
		try {
			waitUntilWebElementToBeVisible(getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean aguardaSplashSumir() {
		try {
			waitUntilWebElementToBeInvisible(getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
