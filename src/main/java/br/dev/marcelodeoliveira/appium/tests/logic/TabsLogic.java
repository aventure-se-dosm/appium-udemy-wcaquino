package br.dev.marcelodeoliveira.appium.tests.logic;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.TabsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TabsLogic extends BaseLogic {

private TabsPage page;

//	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 1']")
//	private MobileElement aba1;
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Aba 2']")
//	private MobileElement aba2;
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 1']")
//	private MobileElement lblAba1;
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Este é o conteúdo da Aba 2']")
//	private MobileElement lblAba2;
//
//	private MobileElement getAba1() {
//		return aba1;
//	}
//
//	private MobileElement getAba2() {
//		return aba2;
//	}
//
//	private MobileElement getLblAba1() {
//		return lblAba1;
//	}
//
//	private MobileElement getLblAba2() {
//		return lblAba2;
//	}

	public String getlblAba1Txt() {
		return selectAndReturnTabContent(page.getAba1(), page.getLblAba1());
	}

	public String getlblAba2Txt() {
		return selectAndReturnTabContent(page.getAba2(), page.getLblAba2());
	}

	private String selectAndReturnTabContent(MobileElement tab, MobileElement content) {
		if (!isElementSelected(tab))
			click(tab);
		return getText(content);
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new TabsPage();
	}

}
