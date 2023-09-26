package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SwipePage;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeTest extends BaseTest {

	private MenuPage menuPage;
	private SwipePage swipePage;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuPage = new MenuPage();
		this.swipePage = new SwipePage();

	}

	@Test
	public void deveTestarSwipe() {
		// acessar menu
		menuPage.clickSwipe();		

		//verificar texto À esquerda
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Assert.assertTrue(swipePage.isTextPresent("Mova a tela para"));
//		Assert.assertTrue(swipePage.isTextPresent("a esquerda"));

		//swipe à direita
		swipePage.swipeRight();

		//verificar texto "E vejo se"
		//Assert.assertTrue(swipePage.isTextPresent("E veja se"));

		//clicar botão direito
		swipePage.clicaBtnDir();
		
		//verificar texto "você consegue"
//		Assert.assertTrue(swipePage.isTextPresent("você consegue"));
		
		//clicar botão direito
		swipePage.clicaBtnDir();
		//verificar texto "Chegar até o fim"
	//	Assert.assertTrue(swipePage.isTextPresent("Chegar até o fim"));

		//swipe esquerda
		swipePage.swipeLeft();
		
		//clicar botão esquerdo
		swipePage.clicaBtnEsq();
		swipePage.clicaBtnEsq();
		//verificar texto À esquerda
		//Assert.assertTrue(swipePage.isTextPresent("a esquerda"));
		
		
	}

}
