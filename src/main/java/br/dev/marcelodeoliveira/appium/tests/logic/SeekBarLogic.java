package br.dev.marcelodeoliveira.appium.tests.logic;

import org.junit.Assert;
import org.openqa.selenium.Point;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SeekBarPage;

public class SeekBarLogic extends BaseLogic {

	private SeekBarPage page;

	public void moveSeekBarParaPorcentagemEscolhida(Float porcentagem) {

		// TODO: Further refactoring opportunity
		int cursorSquareEdgeMeasure = getWidth(page.getBarCursor());
		int maxCurrentBarLength = getWidth(page.getFullExtentionBar()) - cursorSquareEdgeMeasure;
		int x_ponto;
		int y_ponto;

		Assert.assertEquals(
				String.format("Expected: %d, Actual: %d", maxCurrentBarLength, 1080 - cursorSquareEdgeMeasure),
				maxCurrentBarLength, (1027));
		Assert.assertEquals(String.format("Expected: %d, Actual: %d", 53, cursorSquareEdgeMeasure), 53,
				cursorSquareEdgeMeasure);
		porcentagem -= 0.01f;
		porcentagem /= 0.99f;

		x_ponto = (int) ((maxCurrentBarLength) * porcentagem) + cursorSquareEdgeMeasure - 1;
		y_ponto = (int) (getElementInteractableYAxisRange(page.getSeekBar()) - 1);

		tap(new Point(x_ponto, y_ponto));

	}
	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SeekBarPage();
		
	}

}
