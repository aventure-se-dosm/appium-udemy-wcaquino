package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.login;

import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	private MobileElement txtLoginEmail;
	@AndroidFindBy(xpath = "//android.widget.EditText[2]")
	private MobileElement txtLoginPassword;
	@AndroidFindBy(xpath = "//*[@text='ENTRAR']/ancestor::android.widget.Button")
	private MobileElement btnEntrar;
	@AndroidFindBy(xpath = "//*[@text='RESET']/ancestor::android.widget.Button")
	private MobileElement btnReset;

	public MobileElement getTxtLoginEmail() {
		// TODO Auto-generated method stub
		return txtLoginEmail;
	}

	public MobileElement getTxtLoginPassword() {
		// TODO Auto-generated method stub
		return txtLoginPassword;
	}

	public MobileElement getBtnEntrar() {
		// TODO Auto-generated method stub
		return btnEntrar;
	}

	public WebElement getbtnReset() {
		// TODO Auto-generated method stub
		return btnReset;
	}

}
