package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

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
		
		//	clicar 'SwipeList'
		menuPage.clicaSwipeList();
	}

	
	public void desafioSwipeListTest() {
		
		
		
		//	swipeLeft ( op1 )
		
		//	verificar op1+
		//	swipeLeft( op4 )
		//	clicar ( op4 -)
		//	verificar op4-
		//	swipeRight ( op5 )
		//	//clicar (op5)?
		//	verificar op5
	}
}
