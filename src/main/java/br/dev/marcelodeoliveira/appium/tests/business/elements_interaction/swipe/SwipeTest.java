package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.swipe;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.menu.MenuLogic;

public class SwipeTest extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private SwipeLogic swipeLogic;

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
	protected void setupBaseLogic() {

		this.menuLogic = new MenuLogic();
		this.swipeLogic = new SwipeLogic();
		menuLogic.clickSwipe();
	}

}
