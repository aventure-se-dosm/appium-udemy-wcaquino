package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SeekBarPage extends BasePage {

	@AndroidFindBy(accessibility = "slid")
	private MobileElement seekBar;

	@AndroidFindBy(accessibility = "//*[@content-desc='slid']//android.view.ViewGroup[@index='1']")
	private MobileElement barCursor;
	@AndroidFindBy(accessibility = "//*[@content-desc='slid']//android.view.ViewGroup[@index='3']")
	private MobileElement currentExtentionBar;
	
	
	//*[@content-desc='slid']/

	public MobileElement getSeekBar() {
		return seekBar;
	}

	public MobileElement getCurrentExtentionBar() {
		return currentExtentionBar;
	}

	public MobileElement getBarCursor() {
		return barCursor;
	}

//	public void moveSeekBarParaPorcentagemEscolhida(Float porcentagem) {
//
//		// TODO: REFATORE NA DEV
//		int cursorSquareEdgeMeasure = getWidth(getBarCursor());
//		int maxCurrentBarLength = getWidth(getFullExtentionBar()) - cursorSquareEdgeMeasure;
//		int x_ponto;
//		int y_ponto;
//
//		Assert.assertEquals(
//				String.format("Expected: %d, Actual: %d", maxCurrentBarLength, 1080 - cursorSquareEdgeMeasure),
//				maxCurrentBarLength, (1027));
//		Assert.assertEquals(String.format("Expected: %d, Actual: %d", 53, cursorSquareEdgeMeasure), 53,
//				cursorSquareEdgeMeasure);
//		porcentagem -= 0.01f;
//		porcentagem /= 0.99f;
//
//		x_ponto = (int) ((maxCurrentBarLength) * porcentagem) + cursorSquareEdgeMeasure - 1;
//		y_ponto = (int) (getElementInteractableYAxisRange(getSeekBar()) - 1);
//
//		tap(new Point(x_ponto, y_ponto));
//
//	}

//
//		Assert.assertEquals(
//				String.format("Expected: %d, Actual: %d", maxCurrentBarLength, 1080 - cursorSquareEdgeMeasure),
//				maxCurrentBarLength, (1027));
//		Assert.assertEquals(String.format("Expected: %d, Actual: %d", 53, cursorSquareEdgeMeasure), 53,
//				cursorSquareEdgeMeasure);
//		porcentagem -= 0.01f;
//		porcentagem /= 0.99f;
//
//		x_ponto = (int) ((maxCurrentBarLength) * porcentagem) + cursorSquareEdgeMeasure - 1;
//		y_ponto = (int) (getElementInteractableYAxisRange(getSeekBar()) - 1);
//
//		tap(new Point(x_ponto, y_ponto));
//
//	}

//	public MobileElement getFullExtentionBar() {
//
//		MobileElement m = (MobileElement) getNestedElement(getSeekBar(),
//				By.xpath(".//android.view.ViewGroup[@index='2']"));
//		Assert.assertEquals(m.getSize().width, 1080);
//		return m;
//	}
}
