package br.dev.marcelodeoliveira.appium.tests.business.tabs;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TabsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 1']")
	private MobileElement aba1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 2']")
	private MobileElement aba2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 1']")
	private MobileElement lblAba1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 2']")
	private MobileElement lblAba2;

	public MobileElement getAba1() {
		return aba1;
	}

	public MobileElement getAba2() {
		return aba2;
	}

	public MobileElement getLblAba1() {
		return lblAba1;
	}

	public MobileElement getLblAba2() {
		return lblAba2;
	}
}
