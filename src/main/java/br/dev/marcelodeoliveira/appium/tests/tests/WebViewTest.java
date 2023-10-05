package br.dev.marcelodeoliveira.appium.tests.tests;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.logic.MenuLogic;
import br.dev.marcelodeoliveira.appium.tests.logic.WebViewLogic;

public class WebViewTest extends CTAppiumBaseTestWithGrantPermissions {

	private MenuLogic menuLogic;
	private WebViewLogic webViewLogic;

	@Test
	public void deveLogarSeuBarriga() {
		webViewLogic.setEmail("automation.mrkolv@gmail.com");
		webViewLogic.setSenha("123!");
		webViewLogic.entrar();
		Assert.assertTrue(webViewLogic.getWelcomeLabel().contains("Bem vindo, "));
	}

	@Override
	protected void setupLogic() {

		this.menuLogic = new MenuLogic();
		this.webViewLogic = new WebViewLogic();

		menuLogic.acessarSeuBarrigaHibrido();
		webViewLogic.switchToWebContext();

	}

}
