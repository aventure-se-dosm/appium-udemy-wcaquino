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

	private String selectAndReturnTabContent(MobileElement tab, MobileElement content) {
		if (!isElementSelected(tab))
			click(tab);
		return getText(content);
	}

	public String getlblAba1Txt() {
		return selectAndReturnTabContent(aba1, lblAba1);
	}

	public String getlblAba2Txt() {
		return selectAndReturnTabContent(aba2, lblAba2);
	}

}
