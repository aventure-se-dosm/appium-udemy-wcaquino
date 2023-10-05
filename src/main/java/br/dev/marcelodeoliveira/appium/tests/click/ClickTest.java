package br.dev.marcelodeoliveira.appium.tests.click;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.menu.MenuLogic;

public class ClickTest extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private ClickLogic clickLogic;

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

	@Override
	protected void setupLogic() {

		this.menuLogic = new MenuLogic();
		this.clickLogic = new ClickLogic();
		menuLogic.clicaCliques();
	}

}
