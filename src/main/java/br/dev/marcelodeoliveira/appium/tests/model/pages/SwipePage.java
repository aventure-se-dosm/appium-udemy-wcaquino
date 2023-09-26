package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mova a tela para']")
	public MobileElement txtTela1_1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='a esquerda']")
	private MobileElement txtTela1_2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='E veja se']")
	private MobileElement txtTela2_1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='você consegue']")
	private MobileElement txtTela2_2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Chegar até o fim!']")
	private MobileElement txtTela3_1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='‹']")
	private MobileElement icoSlideToTheLeft;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='›']")
	private MobileElement icoSlideToTheRight;
	
	

	private MobileElement getTxtTela1_1() {
		return txtTela1_1;
	}

	private MobileElement getTxtTela1_2() {
		return txtTela1_2;
	}

	private MobileElement getTxtTela2_1() {
		return txtTela2_1;
	}

	private MobileElement getTxtTela2_2() {
		return txtTela2_2;
	}

	private MobileElement getTxtTela3_1() {
		return txtTela3_1;
	}

	private MobileElement getIcoSlideToTheLeft() {
		return icoSlideToTheLeft;
	}

	private MobileElement getIcoSlideToTheRight() {
		return icoSlideToTheRight;
	}

	
	public void swipeRight() {
		swipeRight(0.25f, 0.75f);
	}
	public void swipeLeft() {
		swipeLeft(0.25f, 0.75f);
	}

	public void clicaBtnDir() {
		click(getIcoSlideToTheRight());
	}
	
	public void clicaBtnEsq() {
		click(getIcoSlideToTheLeft());		
	}


	
	
}
