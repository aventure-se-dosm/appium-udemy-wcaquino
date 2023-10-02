package br.dev.marcelodeoliveira.appium.tests.logic;

import org.openqa.selenium.Point;

import br.dev.marcelodeoliveira.appium.tests.model.pages.AlertPage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;

public class AlertLogic extends BaseLogic {


	private AlertPage page;

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
		tap(getOuterAlertReasonablePoint());
		return getMsgTxt();
	}

	public Point getOuterAlertReasonablePoint() {
		//provisory
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
