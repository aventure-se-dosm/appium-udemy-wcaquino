package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SplashLogic;

public class SplashTest extends CTAppiumBaseTestVersionable{

	private SplashLogic splashLogic;
	private MenuLogic menuLogic;



	@Test
	public void deveAguardarSplashSumir() {
		menuLogic.clicaSplash();
		splashLogic.isSplashExibido();
		Assert.assertEquals("Splash!", splashLogic.getSplashText());
		splashLogic.aguardaSplashSumir();
		Assert.assertTrue(menuLogic.isMenuVisible());

	}

	@Override
	protected void setupLogic() {
		menuLogic = new MenuLogic();
		splashLogic = new SplashLogic();
	}
}
