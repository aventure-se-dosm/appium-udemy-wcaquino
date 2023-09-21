package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AlertPage extends BasePage {

	@AndroidFindBy(id = "idButtonTest1")
	private MobileElement btnAlertaSimples;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest2']")
	private MobileElement btnAlertaRestritivo;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest3']")
	private MobileElement btnAlertaConfirm;

	@AndroidFindBy(id = "android:id/message")
	private MobileElement msgMessage;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement sair;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement alertaConfirmar;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement alertaNegar;

	private MobileElement getMsgMessage() {
		return msgMessage;
	}

	private MobileElement getSair() {
		return sair;
	}

	private MobileElement getAlertaConfirmar() {
		return alertaConfirmar;
	}

	private MobileElement getAlertaNegar() {
		return alertaNegar;
	}

	private MobileElement getBtnAlertaConfirm() {
		return btnAlertaConfirm;
	}

	public String getMsgTxt() {
		return getText(getMsgMessage());
	}

	public String clicaConfirmar() {
		click(getAlertaConfirmar());
		return getMsgTxt();
	}

	public String clicaNegar() {
		click(getAlertaNegar());
		return getMsgTxt();
	}

	public String clicaAlertConfirm() {
		click(getBtnAlertaConfirm());
		return getMsgTxt();
	}

	public String clicaAlertNegar() {
		click(getAlertaNegar());
		return getMsgTxt();
	}

	public void sairAlert() {
		click(getSair());
	}

}
