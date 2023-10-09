package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.movimentacoes;

import org.junit.Assert;
import org.junit.Test;

import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.SeuBarrigaNativoTest;

public class MovTest extends SeuBarrigaNativoTest {

	private MovLogic logic;

	@Test
	public void insereMovimentacaoPorTentativaEErroComSucesso() throws InterruptedException {

		logic.clicaMov();

		logic.selecionaTipoMov("Receita");
		logic.salvar();
		Assert.assertEquals("Descrição é um campo obrigatório", logic.getLblAlertMsg());

		logic.insereDescricao("Comissão abril");
		logic.salvar();
		Assert.assertEquals("Interessado é um campo obrigatório", logic.getLblAlertMsg());

		logic.insereInteressado("M. A. Ghrib");
		logic.salvar();
		Assert.assertEquals("Valor é um campo obrigatório", logic.getLblAlertMsg());

		logic.insereValor("12.45");
		logic.salvar();
		Assert.assertEquals("Conta é um campo obrigatório", logic.getLblAlertMsg());

		logic.selecionaTipoConta("Conta para movimentacoes");
		logic.salvar();
		Assert.assertEquals("Movimentação cadastrada com sucesso", logic.getLblAlertMsgSuccess());

	}

	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {

		//verificar salfo "Conta para Saldo" = 534.00

		//ir para resumo

		//excluir mocimentacao 3

		// validar a mensagem "Movimentação removida com sucesso"

		//atualizar saldos

		//verificar saldo = -1000.00 

	}

	@Override
	protected void setupLogic() {
		this.logic = new MovLogic();
		// TODO Auto-generated method stub

	}

}
