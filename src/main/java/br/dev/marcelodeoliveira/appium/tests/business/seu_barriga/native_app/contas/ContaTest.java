package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.contas;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.SeuBarrigaNativoTest;

public class ContaTest extends SeuBarrigaNativoTest {

	private ContaLogic logic;

	@Test
	public void deveCadastrarContaComSucesso() {
		logic.clickContas();
		logic.cadastraContaComSucesso();

		Assert.assertEquals("Conta adicionada com sucesso", logic.getAlertMessageSuccess());
	}

	@Test
	public void naoCadastraContaComNomeDuplicado() {
		logic.clickContas();
		logic.cadastraContaComMesmoNome();
		Assert.assertEquals("Problemas de comunicação", logic.getAlertMessageFail());
	}

	@Override
	protected void setupLogic() {
		this.logic = new ContaLogic();
	}

}
