package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.core.enums.MobileElementAttribute;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormularioPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'Nome: ')]")
	private MobileElement lblName;

	@AndroidFindBy(accessibility = "nome")
	private MobileElement txtName;

	@AndroidFindBy(accessibility = "console")
	private MobileElement spinner;

	@AndroidFindBy(accessibility = "check")
	private MobileElement chkDate;

	@AndroidFindBy(accessibility = "switch")
	private MobileElement switchHour;

	@AndroidFindBy(id = "android:id/hours")
	private MobileElement lblHours;

	@AndroidFindBy(id = "android:id/minutes")
	private MobileElement lblMinutes;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, ':00')]")
	private MobileElement lblHourAndMinutes;

	@AndroidFindBy(xpath = "//android.widget.Switch/following-sibling::*")
	private MobileElement lblDate;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView")
	private List<MobileElement> menuGameConsoles;

	@AndroidFindBy(accessibility = "save")
	private MobileElement btnSalvar;

	@AndroidFindBy(xpath = "//*[@text='SALVAR DEMORADO']")
	private MobileElement btnSalvarDemorado;

	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
	private List<MobileElement> listAllTextView;

	@AndroidFindBy(xpath = "//*[@content-desc='switch']/following-sibling::android.view.ViewGroup/android.widget.TextView")
	private MobileElement btnDate;

	@AndroidFindAll(@AndroidBy(xpath = "//android.view.View[@resource-id='android:id/month_view']/*"))
	private List<MobileElement> listBtnDias;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOk;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancelar;
	
	@AndroidFindBy(xpath = "//*[@content-desc='switch']/following-sibling::*[2]/android.widget.TextView")
	private MobileElement lblTime;
	

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancel;

	@AndroidFindBy(id = "android:id/toggle_mode")
	private MobileElement btnKeyboardInput;

	@AndroidFindBy(id = "android:id/input_hour")
	private MobileElement txtHour;

	@AndroidFindBy(id = "android:id/input_minute")
	private MobileElement txtMinute;

	public MobileElement getBtnSalvarDemorado() {
		return btnSalvarDemorado;
	}


	public MobileElement getBtnDate() {
		return btnDate;
	}

	public List<MobileElement> getListBtnDias() {
		return listBtnDias;
	}

	public MobileElement getLblName() {
		return lblName;
	}

	public MobileElement getTxtName() {
		return txtName;
	}

	public MobileElement getLblHourAndMinutes() {
		return lblHourAndMinutes;
	}

	public MobileElement getLblDate() {
		return lblDate;
	}

	public MobileElement getSpinner() {
		return spinner;
	}

	public MobileElement getChkDate() {
		return chkDate;
	}

	public MobileElement getSwitchHour() {
		return switchHour;
	}

	public MobileElement getMenuGame(String console) {
		return getMenuGameConsoles().stream().filter(e -> e.getText().equalsIgnoreCase(console)).findFirst().get();
	}

	public List<MobileElement> getMenuGameConsoles() {

		return menuGameConsoles;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public List<MobileElement> getListAllTextView() {
		return listAllTextView;
	}
	
	public MobileElement getBtnOk() {
		return btnOk;
	}

	public MobileElement getLblTime() {
		return lblTime;
	}

	public MobileElement getBtnKeyboardInput() {
		return btnKeyboardInput;
	}

	public MobileElement getTxtHour() {
		return txtHour;
	}

	public MobileElement getTxtMinute() {
		return txtMinute;
	}

	private By listRdbHourMinute = By.xpath("//*[@resource-id='android:id/radial_picker']/*");

	private By getListRdbHourMinute() {
		return listRdbHourMinute;
	}

	public MobileElement getHora(Integer hour) {
		return getMobileElementTextByAttribute(getListRdbHourMinute(), MobileElementAttribute.CONTENT_DESC, hour);
	}

	private MobileElement getMobileElementTextByAttribute(By by, MobileElementAttribute attribute, Object value) {
		List<WebElement> listElem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return (MobileElement) listElem.stream()
				.filter(elem -> elem.getAttribute(attribute.getName()).equals(value.toString())).findFirst().get();
	}

	public MobileElement getMinuto(Integer minuto) {
		return getMobileElementTextByAttribute(getListRdbHourMinute(), MobileElementAttribute.CONTENT_DESC, minuto);
	}
	

}