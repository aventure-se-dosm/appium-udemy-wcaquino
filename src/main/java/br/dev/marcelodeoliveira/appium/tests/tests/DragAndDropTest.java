package br.dev.marcelodeoliveira.appium.tests.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.DragAndDropLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;

public class DragAndDropTest extends CTAppiumBaseTestVersionable{

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
	protected void setupLogic() {
		// TODO Auto-generated method stub
		
		this.menuLogic = new MenuLogic();
		this.dragAndDropLogic = new DragAndDropLogic();
		menuLogic.clicaDragAndDrop();
	}

}
