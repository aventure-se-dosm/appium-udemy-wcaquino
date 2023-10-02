package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.model.pages.AccordionPage;
import io.appium.java_client.remote.MobileCapabilityType;


public class AccordionTest extends BaseTest {
	private AccordionPage accordionPage;
	private MenuLogic menuLogic;

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.accordionPage = new AccordionPage();
		this.menuLogic = new MenuLogic();
	}

	@Test
	public void deveIteragirComAccordionOpcao1() {
	
		menuLogic.clicaAccordion();
	
		accordionPage.getSelectOption1();
	
		Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.getTxtOpcao1Txt());

	}

}
