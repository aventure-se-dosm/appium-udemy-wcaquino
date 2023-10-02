package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccordionPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Opção 1']")
	private MobileElement btnOpcao1;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Opção 1']/../../following-sibling::android.view.ViewGroup/android.widget.TextView")
	private MobileElement txtOpcao1;

	public MobileElement getTxtOpcao1() {
		return txtOpcao1;
	}

	public MobileElement getBtnOpcao1() {
		return btnOpcao1;
	}
//
//	public String getTxtOpcao1Txt() {
//		return getText(getTxtOpcao1());
//	}
//
//	public void getSelectOption1() {
//		click(getBtnOpcao1());
//	}
//
//	public String getAccordion1Text() {
//		return getText(getTxtOpcao1());
//	}

}
