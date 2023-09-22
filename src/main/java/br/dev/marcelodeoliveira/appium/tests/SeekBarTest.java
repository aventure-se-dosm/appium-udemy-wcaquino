package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Before;

import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SeekBarPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class SeekBarTest extends BaseTest {

	MenuPage menuPage;
	SeekBarPage seekBarPage;

	@Override
	@Before
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuPage = new MenuPage();
		this.seekBarPage = new SeekBarPage();
	}

}
