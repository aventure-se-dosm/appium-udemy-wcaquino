package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.drag_and_drop;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.menu.MenuLogic;

public class DragAndDropTest extends CTAppiumBaseTestVersionable {

	private DragAndDropLogic dragAndDropLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveEfetuarDragAndDrop() {

		assertArrayEquals(dragAndDropLogic.getExpectedInitialState(), dragAndDropLogic.getCurrentState());

		dragAndDropLogic.drag("Esta", "e arraste para");

		assertArrayEquals(dragAndDropLogic.getExpectedIntermediateState(), dragAndDropLogic.getCurrentState());

		dragAndDropLogic.drag("Faça um clique longo,", "é uma lista");

		assertArrayEquals(dragAndDropLogic.getExpectedFinalState(), dragAndDropLogic.getCurrentState());

	}

	@Override
	protected void setupBaseLogic() {
		this.menuLogic = new MenuLogic();
		this.dragAndDropLogic = new DragAndDropLogic();
		menuLogic.clicaDragAndDrop();
	}

}
