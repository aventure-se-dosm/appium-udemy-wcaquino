package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AlertPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[1]")
//  @AndroidFindBy(id = "idButtonTest")
	public MobileElement btnAlertaSimples;

	@AndroidFindBy(xpath = "//android.widget.Button[2]")
	private MobileElement btnAlertaRestritivo;

	@AndroidFindBy(xpath = "//android.widget.Button[3]")
	private MobileElement btnAlertaConfirm;

	@AndroidFindBy(id = "android:id/message")
	private MobileElement msgMessage;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnAlertSair;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnAlertOk;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement alertaConfirmar;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement alertaNegar;

	@AndroidFindBy(id = "android:id/parentPanel")
	private MobileElement alertFrame;

	public MobileElement getBtnAlertaConfirm() {
		return btnAlertaConfirm;
	}

	public MobileElement getBtnAlertaRestritivo() {
		return btnAlertaRestritivo;
	}

	public MobileElement getBtnAlertaSimples() {
		return btnAlertaSimples;
	}

	public MobileElement getMsgMessage() {
		return msgMessage;
	}

	public MobileElement getBtnAlertOk() {
		return btnAlertOk;
	}

	public MobileElement getBtnAlertSair() {
		return btnAlertSair;
	}

	public MobileElement getAlertaConfirmar() {
		return alertaConfirmar;
	}

	public MobileElement getAlertaNegar() {
		return alertaNegar;
	}

	public MobileElement getAlertFrame() {
		return alertFrame;
	}

}
