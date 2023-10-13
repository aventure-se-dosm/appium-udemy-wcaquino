package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash!']")
	private MobileElement txtSplash;

	public MobileElement getTxtSplash() {
		return txtSplash;
	}
}
