package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SwipeListLogic;

public class SwipeListTest extends CTAppiumBaseTestVersionable {

	private SwipeListLogic swipeListLogic;
	private MenuLogic menuLogic;

	@Test
	public void desafioSwipeListTest() {

		String swipeText;
		swipeText = swipeListLogic.swipeEsquerdaComCliqueNoSinal("1", "POSITIVO");
		Assert.assertEquals("Opção 1 (+)", swipeText);
		Assert.assertEquals("Opção 1 (+)", swipeText);

		swipeText = swipeListLogic.swipeEsquerdaComCliqueNoSinal("4", "NEGATIVO");
		Assert.assertEquals("Opção 4 (-)", swipeText);
		
		swipeText = swipeListLogic.swipeDireita("5");
		Assert.assertEquals("Opção 5", swipeText);
	}

	@Override
	protected void setupLogic() {
		this.menuLogic = new MenuLogic();
		this.swipeListLogic = new SwipeListLogic();

		menuLogic.clicaSwipeList();
	}
}
