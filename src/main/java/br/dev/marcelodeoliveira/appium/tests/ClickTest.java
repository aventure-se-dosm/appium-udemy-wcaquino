package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.ClickLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;


public class ClickTest extends BaseTest {

	private MenuLogic menuLogic;
	private ClickLogic clickLogic;

	@Override
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.clickLogic = new ClickLogic();	
		menuLogic.clicaCliques();
	}
	
	@Test
	public void deveFazerUmCliqueLongo() {
		clickLogic.cliqueLongo();
		Assert.assertTrue(clickLogic.getDisplayContent().equalsIgnoreCase("Clique Longo"));
		
	}
	@Test
	public void deveFazerUmCliqueDuploRapido() {
		clickLogic.cliqueDuploRapido();
		Assert.assertTrue(clickLogic.getDisplayContent().equalsIgnoreCase("Duplo Clique"));
	}
	
	@Test
	public void deveFazerUmCliqueDuploLento() {
		clickLogic.cliqueDuploLento();
		Assert.assertTrue(clickLogic.getDisplayContent().equalsIgnoreCase("Duplo Clique Lento"));
	}

}
