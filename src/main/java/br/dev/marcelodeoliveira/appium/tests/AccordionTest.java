package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.AccordionLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class AccordionTest extends BaseTest {
	private AccordionLogic accordionLogic;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.accordionLogic = new AccordionLogic();
		this.menuLogic = new MenuLogic();
	}

	@Test
	public void deveIteragirComAccordionOpcao1() {

		menuLogic.clicaAccordion();

		accordionLogic.getSelectOption1();

		Assert.assertEquals("Esta é a descrição da opção 1", accordionLogic.getTxtOpcao1Txt());

	}

}
