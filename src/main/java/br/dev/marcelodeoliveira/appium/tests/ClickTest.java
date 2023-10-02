package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.model.pages.ClickPage;
import io.appium.java_client.remote.MobileCapabilityType;


public class ClickTest extends BaseTest {

	private MenuLogic menuLogic;
	private ClickPage clickPage;

	@Override
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.clickPage = new ClickPage();	
		menuLogic.clicaCliques();
	}
	
	@Test
	public void deveFazerUmCliqueLongo() {
		clickPage.cliqueLongo();
		Assert.assertTrue(clickPage.getDisplayContent().equalsIgnoreCase("Clique Longo"));
		
	}
	@Test
	public void deveFazerUmCliqueDuploRapido() {
		clickPage.cliqueDuploRapido();
		Assert.assertTrue(clickPage.getDisplayContent().equalsIgnoreCase("Duplo Clique"));
	}
	
	@Test
	public void deveFazerUmCliqueDuploLento() {
		clickPage.cliqueDuploLento();
		Assert.assertTrue(clickPage.getDisplayContent().equalsIgnoreCase("Duplo Clique Lento"));
	}

}
