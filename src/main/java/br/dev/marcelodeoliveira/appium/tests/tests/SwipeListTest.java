package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SwipeListLogic;

public class SwipeListTest extends CTAppiumBaseTestVersionable{

	private SwipeListLogic swipeListLogic;
	private MenuLogic menuLogic;


	@Test
	public void desafioSwipeListTest() {

		// swipeLeft ( op1 )
		String swipeText;
		swipeText = swipeListLogic.swipeEsquerdaComCliqueNoSinal("1", "POSITIVO");
		Assert.assertEquals("Opção 1 (+)", swipeText);
		Assert.assertEquals("Opção 1 (+)", swipeText);
		// swipeLeft( op4 )
		// clicar ( op4 -)
		// verificar op4-
		swipeText = swipeListLogic.swipeEsquerdaComCliqueNoSinal("4", "NEGATIVO");
		Assert.assertEquals("Opção 4 (-)", swipeText);
		// swipeRight ( op5 )
		// //clicar (op5)?
		// verificar op5
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
