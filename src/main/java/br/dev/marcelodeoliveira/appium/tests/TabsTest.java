package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.TabsLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class TabsTest extends BaseTest {

	MenuLogic menuLogic;
	TabsLogic tabsPage;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.tabsPage = new TabsLogic();

	}

	@Test
	public void deveTestarAbas() {

		String lblAba1 = "Este é o conteúdo da Aba 1";
		String lblAba2 = "Este é o conteúdo da Aba 2";

		menuLogic.clicaAbas();

		Assert.assertEquals(tabsPage.getlblAba1Txt(), lblAba1);
		Assert.assertEquals(tabsPage.getlblAba2Txt(), lblAba2);

	}
}
