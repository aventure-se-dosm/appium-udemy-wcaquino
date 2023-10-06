package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.tabs;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class TabsLogic extends BaseLogic {

	private TabsPage page;

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
