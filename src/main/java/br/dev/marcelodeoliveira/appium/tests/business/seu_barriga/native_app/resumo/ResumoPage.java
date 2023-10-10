package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.resumo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ResumoPage extends BasePage{

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ATUALIZAR']/../*")
	MobileElement btnAtualizar;

	// @AndroidFindBy(xpath="android.widget.TextView[@text='Del']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Del']/..")
	MobileElement btnDel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ATUALIZAR']/../../*[4]")
	MobileElement lblAlert;

	By testTransactionToExclude = By.xpath("//android.widget.TextView[@text='Movimentacao 3, calculo saldo']");

	public MobileElement getBtnAtualizar() {
		return btnAtualizar;
	}

	public MobileElement getBtnDel() {
		return btnDel;
	}

	public MobileElement getLblAlert() {
		return lblAlert;
	}

	public By getTestTransactionToExclude() {
		return testTransactionToExclude;
	}

	public WebElement getDelButton() {
		return btnDel;
	}

}
