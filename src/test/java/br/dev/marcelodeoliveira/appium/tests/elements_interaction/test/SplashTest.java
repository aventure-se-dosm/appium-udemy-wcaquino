package br.dev.marcelodeoliveira.appium.tests.elements_interaction.test;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.SplashLogic;

public class SplashTest extends CTAppiumBaseTestVersionable {

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
	protected void setupBaseLogic() {
		menuLogic = new MenuLogic();
		splashLogic = new SplashLogic();
	}
}
