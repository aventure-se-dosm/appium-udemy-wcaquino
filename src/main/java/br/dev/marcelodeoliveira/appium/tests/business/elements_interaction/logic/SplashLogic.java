package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import org.openqa.selenium.TimeoutException;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.SplashPage;

public class SplashLogic extends BaseLogic {

	private SplashPage page;

	public Object getSplashText() {

		return getText(page.getTxtSplash());
	}

	public boolean isSplashExibido() {
		try {
			waitUntilWebElementToBeVisibleAndNotNull(page.getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean aguardaSplashSumir() {
		try {
			waitUntilMobileElementToBeInvisible(page.getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SplashPage();

	}
}
