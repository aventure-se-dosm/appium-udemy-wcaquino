package br.dev.marcelodeoliveira.appium.tests.logic;

import org.openqa.selenium.TimeoutException;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SplashPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashLogic extends BaseLogic {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Splash!']")
	private MobileElement txtSplash;
	private SplashPage page;

	public MobileElement getTxtSplash() {
		return txtSplash;
	}

	public Object getSplashText() {
		return getTxtSplash().getText();
	}

	public boolean isSplashExibido() {
		try {
			waitUntilWebElementToBeVisibleAndItsNotNull(page.getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean aguardaSplashSumir() {
		try {
			waitUntilMobileElementToBeInvisible(getTxtSplash());
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page= new SplashPage();
		
	}
}
