package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.DragAndDropLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDropTest extends BaseTest {

	private DragAndDropLogic dragAndDropLogic;
	private MenuLogic menuLogic;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		// setupDriver();
		this.menuLogic = new MenuLogic();
		this.dragAndDropLogic = new DragAndDropLogic();
		/**
		 * 
		 * //setupCtxDragNDrop(); //
		 * 
		 *
		 */
		// Acessar menu
		// --- clicar "Drag and drop"
		menuLogic.clicaDragAndDrop();

	}

	@Test
	public void deveEfetuarDragAndDrop() {

		assertArrayEquals(dragAndDropLogic.getExpectedInitialState(), dragAndDropLogic.getCurrentState());

		dragAndDropLogic.drag("Esta", "e arraste para");

		assertArrayEquals(dragAndDropLogic.getExpectedIntermediateState(), dragAndDropLogic.getCurrentState());

		dragAndDropLogic.drag("Faça um clique longo,", "é uma lista");

		assertArrayEquals(dragAndDropLogic.getExpectedFinalState(), dragAndDropLogic.getCurrentState());

	}

}
