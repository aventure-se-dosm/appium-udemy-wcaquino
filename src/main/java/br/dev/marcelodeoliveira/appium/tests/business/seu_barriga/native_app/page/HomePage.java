package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.page;

import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='534.00']")
	WebElement lblTargetAccountBalance;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Conta para saldo']/following-sibling::*")
	WebElement lblTargetAccountNewBalance;

	public WebElement getLblTargetAccountBalance() {
		return lblTargetAccountBalance;
	}

	public WebElement getNovoSaldoContaTarget() {
		return lblTargetAccountNewBalance;
	}

}
