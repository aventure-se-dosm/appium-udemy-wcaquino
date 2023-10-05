package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SeekBarPage extends BasePage {

	@AndroidFindBy(accessibility = "slid")
	private MobileElement seekBar;

	@AndroidFindBy(xpath = "//*[@content-desc='slid']//android.view.ViewGroup[@index='1']")
	private MobileElement barCursor;

	@AndroidFindBy(xpath = "//*[@content-desc='slid']//android.view.ViewGroup[@index='3']")
	private MobileElement currentExtentionBar;

	public MobileElement getSeekBar() {
		return seekBar;
	}

	public MobileElement getCurrentExtentionBar() {
		return currentExtentionBar;
	}

	public MobileElement getBarCursor() {
		return barCursor;
	}
}
