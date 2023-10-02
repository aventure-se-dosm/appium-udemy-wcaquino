package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.core.DriverFactory.setupDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.FormularioLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.SeekBarLogic;
import io.appium.java_client.remote.MobileCapabilityType;

public class SeekBarTest extends BaseTest {

	MenuLogic menuLogic;
	SeekBarLogic seekBarLogic;
	private FormularioLogic formularioLogic;

	@Override
	@Before
	public void setupTest() {

		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();

		this.menuLogic = new MenuLogic();
		this.formularioLogic = new FormularioLogic();
		this.seekBarLogic = new SeekBarLogic();
	}

	@Test
	public void moveSeekBar() {
		Float porcentagem = 0.76f;
		menuLogic.clicaFormulario();
		seekBarLogic.moveSeekBarParaPorcentagemEscolhida(porcentagem);
		formularioLogic.salvarForm();
		String resp = formularioLogic.getFormResponseAttribute("Slider");
		Assert.assertTrue(resp, resp.contains(Integer.toString((int) (porcentagem * 100f))));
	}

}
