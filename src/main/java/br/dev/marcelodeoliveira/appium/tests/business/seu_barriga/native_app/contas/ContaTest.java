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
	public void naoDeveCadastrarContaComNomeDuplicado() {
		logic.clickContas();
		logic.cadastraContaComMesmoNome();
		Assert.assertEquals("Problemas de comunicação", logic.getAlertMessageFail());
	}

	@Test
	public void deveExcluirContaComSucesso() {

		final String CONTA_PARA_EXCLUSAO = "Conta para Exclusão";
		logic.clickContas();
		logic.cadastraConta(CONTA_PARA_EXCLUSAO);
		logic.excluiConta(CONTA_PARA_EXCLUSAO);
		Assert.assertEquals("Conta excluída com sucesso", logic.getAlertContaSalva());
	}

	@Test
	public void naoDeveExcluirContaComMovimentacao() {

		final String CONTA_COM_MOVIMENTACAO = "Conta com movimentacao";
		logic.clickContas();
		logic.excluiConta(CONTA_COM_MOVIMENTACAO);
		Assert.assertEquals("Conta em uso nas movimentações", logic.getAlertErrorContaEmUso());
	}
	

	@Override
	protected void setupLogic() {
		this.logic = new ContaLogic();
	}

}
