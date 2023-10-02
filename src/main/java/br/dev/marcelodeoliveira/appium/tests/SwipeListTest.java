package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SwipeListLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeListTest extends BaseTest {

	private SwipeListLogic swipeListLogic;
	private MenuLogic menuLogic;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuLogic = new MenuLogic();
		this.swipeListLogic = new SwipeListLogic();

		// clicar 'SwipeList'
		menuLogic.clicaSwipeList();
	}

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
}
