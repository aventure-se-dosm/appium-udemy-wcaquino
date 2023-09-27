package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AlertPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest']")
	public MobileElement btnAlertaSimples;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest2']")
	private MobileElement btnAlertaRestritivo;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest3']")
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

	private MobileElement getBtnAlertaConfirm() {
		return btnAlertaConfirm;
	}

	private MobileElement getBtnAlertaRestritivo() {
		return btnAlertaRestritivo;
	}

	private MobileElement getBtnAlertaSimples() {
		return btnAlertaSimples;
	}

	private MobileElement getMsgMessage() {
		return msgMessage;
	}

	private MobileElement getBtnAlertOk() {
		return btnAlertOk;
	}

	private MobileElement getBtnAlertSair() {
		return btnAlertSair;
	}

	private MobileElement getAlertaConfirmar() {
		return alertaConfirmar;
	}

	private MobileElement getAlertaNegar() {
		return alertaNegar;
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

	public String clicaAlertSimples() {
		click(getBtnAlertaSimples());	
		tap(100, 100); //provisory;
		return getMsgTxt();
	}

	public String clicaAlertNegar() {
		click(getAlertaNegar());
		return getMsgTxt();
	}

	public void sairAlert() {
		click(getBtnAlertSair());
	}

	public void clicaOk() {
		click(getBtnAlertOk());
	}

	public void clicaSair() {
		click(getBtnAlertSair());
	}

	private MobileElement getAlertFrame() {
		return alertFrame;
	}

	public boolean isAlertPresent() {
		return waitUntilWebElementToBeVisibleAndItsNotNull(getAlertFrame());
	}

	public boolean isAlertInvisibleOrAbsent() {
		return waitUntilMobileElementToBeInvisible(getAlertFrame());
	}

	public String clicaAlertRestritivo() {
		click(getBtnAlertaRestritivo());
		return getMsgTxt();
	}

}
