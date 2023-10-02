package br.dev.marcelodeoliveira.appium.tests.logic;

import org.openqa.selenium.Point;

import br.dev.marcelodeoliveira.appium.tests.model.pages.AlertPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;

public class AlertLogic extends BaseLogic {

//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest']")
//	public MobileElement btnAlertaSimples;
//
//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest2']")
//	private MobileElement btnAlertaRestritivo;
//
//	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='idButtonTest3']")
//	private MobileElement btnAlertaConfirm;
//
//	@AndroidFindBy(id = "android:id/message")
//	private MobileElement msgMessage;
//
//	@AndroidFindBy(id = "android:id/button1")
//	private MobileElement btnAlertSair;
//
//	@AndroidFindBy(id = "android:id/button1")
//	private MobileElement btnAlertOk;
//
//	@AndroidFindBy(id = "android:id/button2")
//	private MobileElement alertaConfirmar;
//
//	@AndroidFindBy(id = "android:id/button1")
//	private MobileElement alertaNegar;
//
//	@AndroidFindBy(id = "android:id/parentPanel")
//	private MobileElement alertFrame;

	private AlertPage page;

//	private MobileElement getBtnAlertaConfirm() {
//		return btnAlertaConfirm;
//	}
//
//	private MobileElement getBtnAlertaRestritivo() {
//		return btnAlertaRestritivo;
//	}
//
//	private MobileElement getBtnAlertaSimples() {
//		return btnAlertaSimples;
//	}
//
//	private MobileElement getMsgMessage() {
//		return msgMessage;
//	}
//
//	private MobileElement getBtnAlertOk() {
//		return btnAlertOk;
//	}
//
//	private MobileElement getBtnAlertSair() {
//		return btnAlertSair;
//	}
//
//	private MobileElement getAlertaConfirmar() {
//		return alertaConfirmar;
//	}
//
//	private MobileElement getAlertaNegar() {
//		return alertaNegar;
//	}

	public String getMsgTxt() {
		return getText(page.getMsgMessage());
	}

	public String clicaConfirmar() {
		click(page.getAlertaConfirmar());
		return getMsgTxt();
	}

	public String clicaNegar() {
		click(page.getAlertaNegar());
		return getMsgTxt();
	}

	public String clicaAlertConfirm() {
		click(page.getBtnAlertaConfirm());
		return getMsgTxt();
	}

	public String clicaAlertSimples() {
		click(page.getBtnAlertaSimples());
		tap(page.getOuterAlertReasonablePoint());
		return getMsgTxt();
	}

	private Point getOuterAlertReasonablePoint() {
		return new Point(100, 100);
	}

	public String clicaAlertNegar() {
		click(page.getAlertaNegar());
		return getMsgTxt();
	}

	public void sairAlert() {
		click(page.getBtnAlertSair());
	}

	public void clicaOk() {
		click(page.getBtnAlertOk());
	}

	public void clicaSair() {
		click(page.getBtnAlertSair());
	}

	public boolean isAlertPresent() {
		return waitUntilWebElementToBeVisibleAndItsNotNull(page.getAlertFrame());
	}

	public boolean isAlertInvisibleOrAbsent() {
		return waitUntilMobileElementToBeInvisible(page.getAlertFrame());
	}

	public String clicaAlertRestritivo() {
		click(page.getBtnAlertaRestritivo());
		return getMsgTxt();
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new AlertPage();

	}

}
