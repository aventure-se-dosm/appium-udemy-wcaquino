package br.dev.marcelodeoliveira.appium.tests.logic;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SeekBarPage;
import io.appium.java_client.MobileElement;

public class SeekBarLogic extends BaseLogic {

	private SeekBarPage page;

	public void moveSeekBarParaPorcentagemEscolhida(Float porcentagem) {

		// TODO: Further refactoring opportunity
		int cursorSquareEdgeMeasure = getWidth(getBarCursor());

		int maxCurrentBarLength = getWidth(getFullExtentionBar()) - cursorSquareEdgeMeasure;
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

	public MobileElement getCurrentExtentionBar() {
		return page.getSeekBar().findElement(By.xpath(".//android.view.ViewGroup[@index='3']"));

	}

	public MobileElement getBarCursor() {
		return page.getSeekBar().findElement(By.xpath(".//android.view.ViewGroup[@index='1']"));
	}

	// TODO: Use baseLogic methods for cetting nested elements from another one.
//	public MobileElement getFullExtentionBar() {
//
//		MobileElement m = (MobileElement) getNestedElement(page.getSeekBar(),
//				By.xpath(".//android.view.ViewGroup[@index='2']"));
//		Assert.assertEquals(m.getSize().width, 1080);
//		return m;
//	}

	public WebElement getFullExtentionBar() {

		MobileElement m = (MobileElement) getNestedElement(page.getSeekBar(),
				By.xpath(".//android.view.ViewGroup[@index='2']"));
		Assert.assertEquals(m.getSize().width, 1080);
		return m;
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SeekBarPage();

	}

}
