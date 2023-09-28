package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SwipeListPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeListTest extends BaseTest {

	private SwipeListPage swipeListPage;
	private MenuPage menuPage;

	@Override
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
		this.menuPage = new MenuPage();
		this.swipeListPage = new SwipeListPage();

		// clicar 'SwipeList'
		menuPage.clicaSwipeList();
	}

	@Test
	public void desafioSwipeListTest() {

		// swipeLeft ( op1 )
		String swipeText;
		swipeText = swipeListPage.swipeEsquerdaComCliqueNoSinal("1", "POSITIVO");
		Assert.assertEquals("Opção 1 (+)", swipeText);
		Assert.assertEquals("Opção 1 (+)", swipeText);
		// swipeLeft( op4 )
		// clicar ( op4 -)
		// verificar op4-
		swipeText = swipeListPage.swipeEsquerdaComCliqueNoSinal("4", "NEGATIVO");
		Assert.assertEquals("Opção 4 (-)", swipeText);
		// swipeRight ( op5 )
		// //clicar (op5)?
		// verificar op5
		swipeText = swipeListPage.swipeDireita("5");
		Assert.assertEquals("Opção 5", swipeText);
	}
}
