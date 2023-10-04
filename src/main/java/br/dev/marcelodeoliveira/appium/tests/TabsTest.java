package br.dev.marcelodeoliveira.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.TabsLogic;

public class TabsTest extends CTAppiumBaseTestVersionable{

	MenuLogic menuLogic;
	TabsLogic tabsPage;

//	@Before
//	public void setupTest() {
//		setDefaultCapabilities();
//		addCapability(MobileCapabilityType.APP,
//				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
//		setupDriver();
//
//	}

	@Test
	public void deveTestarAbas() {

		String lblAba1 = "Este é o conteúdo da Aba 1";
		String lblAba2 = "Este é o conteúdo da Aba 2";


		Assert.assertEquals(tabsPage.getlblAba1Txt(), lblAba1);
		Assert.assertEquals(tabsPage.getlblAba2Txt(), lblAba2);

	}

	@Override
	public void setupLogic() {

		
		this.menuLogic = new MenuLogic();
		this.tabsPage = new TabsLogic();
		menuLogic.clicaAbas();
		
	}
}
