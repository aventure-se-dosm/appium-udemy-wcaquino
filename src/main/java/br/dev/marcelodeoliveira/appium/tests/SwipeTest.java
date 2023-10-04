package br.dev.marcelodeoliveira.appium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SwipeLogic;

public class SwipeTest extends CTAppiumBaseTestVersionable{

	private MenuLogic menuLogic;
	private SwipeLogic swipeLogic;

//	@Override
//	public void setupTest() {
//		setDefaultCapabilities();
//		addCapability(MobileCapabilityType.APP,
//				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
//		setupDriver();
//
//	}

	@Test
	public void deveTestarSwipe() {

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

	@Override
	protected void setupLogic() {
		// TODO Auto-generated method stub
		this.menuLogic = new MenuLogic();
		this.swipeLogic = new SwipeLogic();
		menuLogic.clickSwipe();
	}

}
