package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TabsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 1']")
	MobileElement aba1;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 2']")
	MobileElement aba2;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 1']")
	MobileElement lblAba1;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 2']")
	MobileElement lblAba2;

	private MobileElement getAba1() {
		return aba1;
	}

	private MobileElement getAba2() {
		return aba2;
	}

	private MobileElement getLblAba1() {
		return lblAba1;
	}

	private MobileElement getLblAba2() {
		return lblAba2;
	}

	public String getlblAba1Txt() {
		return selectAndReturnTabContent(getAba1(), getLblAba1());
	}

	public String getlblAba2Txt() {
		return selectAndReturnTabContent(getAba2(), getLblAba2());
	}

	private String selectAndReturnTabContent(MobileElement tab, MobileElement content) {
		if (!isElementSelected(tab))
			click(tab);
		return getText(content);
	}

}
