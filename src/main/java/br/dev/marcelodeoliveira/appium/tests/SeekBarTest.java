package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.model.pages.FormularioPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.MenuPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SeekBarPage;
import io.appium.java_client.remote.MobileCapabilityType;

public class SeekBarTest extends BaseTest {

	MenuPage menuPage;
	SeekBarPage seekBarPage;
	private FormularioPage formularioPage;

	@Override
	@Before
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuPage = new MenuPage();
		this.formularioPage = new FormularioPage();
		this.seekBarPage = new SeekBarPage();
	}

	@Test
	public void moveSeekBar() {
		Float porcentagem = 0.76f;
		menuPage.clicaFormulario();
		seekBarPage.moveSeekBarParaPorcentagemEscolhida(porcentagem);
		formularioPage.salvarForm();
		String resp = formularioPage.getFormResponseAttribute("Slider");
		Assert.assertTrue(resp, resp.contains(Integer.toString((int) (porcentagem * 100f))));
	}

}
