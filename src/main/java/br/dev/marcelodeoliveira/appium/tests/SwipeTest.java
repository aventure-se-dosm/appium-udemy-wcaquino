package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SwipeLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeTest extends BaseTest {

	private MenuLogic menuLogic;
	private SwipeLogic swipeLogic;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuLogic = new MenuLogic();
		this.swipeLogic = new SwipeLogic();

	}

	@Test
	public void deveTestarSwipe() {

		menuLogic.clickSwipe();
		Assert.assertTrue(swipeLogic.isTextPresent("Mova a tela para"));
		Assert.assertTrue(swipeLogic.isTextPresent("a esquerda"));

		swipeLogic.swipeLeft();
		Assert.assertTrue(swipeLogic.isTextPresent("E veja se"));
		Assert.assertTrue(swipeLogic.isTextPresent("você consegue"));

		swipeLogic.clicaBtnDir();
		Assert.assertTrue(swipeLogic.isTextPresent("Chegar até o fim!"));
		swipeLogic.swipeRight();
		Assert.assertTrue(swipeLogic.isTextPresent("E veja se"));
		Assert.assertTrue(swipeLogic.isTextPresent("você consegue"));

		swipeLogic.clicaBtnEsq();
		Assert.assertTrue(swipeLogic.isTextPresent("a esquerda"));
	}

}
