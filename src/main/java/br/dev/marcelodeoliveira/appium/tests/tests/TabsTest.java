package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.TabsLogic;

public class TabsTest extends CTAppiumBaseTestVersionable {

	private MenuLogic menuLogic;
	private TabsLogic tabsPage;

	final String LBL_ABA_1 = "Este é o conteúdo da Aba 1";
	final String LBL_ABA_2 = "Este é o conteúdo da Aba 2";

	@Test
	public void deveTestarAbas() {

		Assert.assertEquals(tabsPage.getlblAba1Txt(), LBL_ABA_1);
		Assert.assertEquals(tabsPage.getlblAba2Txt(), LBL_ABA_2);
	}

	@Override
	public void setupLogic() {

		this.menuLogic = new MenuLogic();
		this.tabsPage = new TabsLogic();
		menuLogic.clicaAbas();

	}
}
