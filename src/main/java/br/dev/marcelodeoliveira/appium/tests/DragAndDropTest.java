package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.model.pages.DragAndDropPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDropTest extends BaseTest {

	private DragAndDropPage dragAndDropPage;
	private MenuLogic menuLogic;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		// setupDriver();
		this.menuLogic = new MenuLogic();
		this.dragAndDropPage = new DragAndDropPage();
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

		assertArrayEquals(dragAndDropPage.getExpectedInitialState(), dragAndDropPage.getCurrentState());

		dragAndDropPage.drag("Esta", "e arraste para");

		assertArrayEquals(dragAndDropPage.getExpectedIntermediateState(), dragAndDropPage.getCurrentState());

		dragAndDropPage.drag("Faça um clique longo,", "é uma lista");

		assertArrayEquals(dragAndDropPage.getExpectedFinalState(), dragAndDropPage.getCurrentState());

	}

}
