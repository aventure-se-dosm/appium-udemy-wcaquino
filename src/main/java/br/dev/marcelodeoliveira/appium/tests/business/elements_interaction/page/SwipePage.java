package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mova a tela para']")
	private MobileElement txtTela1_1;

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

	public MobileElement getIcoSlideToTheLeft() {
		return icoSlideToTheLeft;
	}

	public MobileElement getIcoSlideToTheRight() {
		return icoSlideToTheRight;
	}

}