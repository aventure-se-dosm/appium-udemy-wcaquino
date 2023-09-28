package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;
import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.DragAndDropPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDropTest extends BaseTest {

	private DragAndDropPage dragAndDropPage;
	private MenuPage menuPage;
	private List<String> ctxDragNDrop;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuPage = new MenuPage();
		this.dragAndDropPage = new DragAndDropPage();
		/**
		 * 
		 * //setupCtxDragNDrop(); //
		 * 
		 *
		 */
		// Acessar menu
		// --- clicar "Drag and drop"
		menuPage.clicaDragAndDrop();

	}

	

	@Test
	public void deveEfetuarDragAndDrop() {

		// Verificar estado inicial --> Então suponha que não muda! Deve estar _as it
		// comes_
		assertArrayEquals(dragAndDropPage.getExpectedInitialState(), dragAndDropPage.getCurrentState());
		/**
		 * sep char <= '|';
		 * 
		 * expecJoinedStr = "Esta|é uma lista|Drag em Drop!|Faça um clique longo,|e
		 * arraste para|qualquer local desejado."
		 */
		// Arrastar "Esta" para e "arrasta para"

		// Verificar estado intermediario

		// Arrastar "Faça um clique longo" para "é uma lista"

		// Verificar estado final
	}

}
