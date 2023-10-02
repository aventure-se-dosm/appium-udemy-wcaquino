package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.Point;

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
		tap(getOuterAlertReasonablePoint());
		return getMsgTxt();
	}

	public Point getOuterAlertReasonablePoint() {
		return new Point(100, 100);
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

	public MobileElement getAlertFrame() {
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
