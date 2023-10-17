package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.steps;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.core.CTAppiumBaseTestVersionable;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.AlertLogic;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic.MenuLogic;;

public class AlertSteps {

	private AlertLogic alertLogic;
	private MenuLogic menuLogic;

	@Test
	public void deveTestarAlertaConfirmNegar() {
		menuLogic.clicaAlertas();
		alertLogic.clicaAlertConfirm();
		alertLogic.clicaAlertNegar();

		Assert.assertEquals("Negado", alertLogic.getMsgTxt());
	}

	@Test
	public void deveTestarAlertaConfirm() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertConfirm();
		alertLogic.clicaConfirmar();

		Assert.assertEquals("Confirmado", alertLogic.getMsgTxt());
		Assert.assertEquals("Confirma a operação?", msg);
		alertLogic.clicaOk();

	}

	@Test
	public void deveClicarForaDoAlertSimplesEMensagemDesaparecer() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertSimples();
		alertLogic.clicaOk();
		Assert.assertEquals("Pode clicar no OK ou fora da caixa para sair", msg);
		Assert.assertTrue(alertLogic.isAlertInvisibleOrAbsent());
	}

	@Test
	public void deveClicarForaDoAlertRestritivoEMensagemPermanecer() {
		menuLogic.clicaAlertas();
		String msg = alertLogic.clicaAlertRestritivo();
		Assert.assertEquals("Não pode clicar fora, apenas no SAIR", msg);
		Assert.assertTrue(alertLogic.isAlertPresent());
		alertLogic.clicaOk();
	}

	@Override
	protected void setupBaseLogic() {

		this.alertLogic = new AlertLogic();
		this.menuLogic = new MenuLogic();

	}

}
