package br.dev.marcelodeoliveira.appium.tests.business.timePicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.core.enums.MobileElementAttribute;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TimePickerPage extends BasePage {

	@AndroidFindBy(xpath = "//*[@content-desc='switch']/following-sibling::*[2]/android.widget.TextView")
	private MobileElement lblTime;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOk;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancel;

	@AndroidFindBy(id = "android:id/toggle_mode")
	private MobileElement btnKeyboardInput;

	@AndroidFindBy(id = "android:id/input_hour")
	private MobileElement txtHour;

	@AndroidFindBy(id = "android:id/input_minute")
	private MobileElement txtMinute;

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

//	public Object getHoraTxt(Integer hora) {
//		return super.getText(getHora(hora));
//	}
//
//	public Object getMinutoTxt(Integer minuto) {
//		return super.getText(getMinuto(minuto));
//	}
//
//	public void selecionaHora(Integer hour, Integer minute) {
//		click(getLblTime());
//		click(getBtnKeyboardInput());
//		writeText(getTxtHour(), hour.toString());
//		writeText(getTxtMinute(), minute.toString());
//
//	}
//
//	public void selecionaHoraSimples(Integer hour, Integer minute) {
//		int roundMinute = roundBy5(minute);
//		System.out.println(minute);
//		Assert.assertTrue(super.getAssertionMessage(50, roundMinute), 50 == roundMinute);
//		click(getLblTime());
//		click(getHora(hour));
//		click(getMinuto(minute));
//
//	}
//
//	private Integer roundBy5(Integer integer) {
//		if (integer % 5 != 0) {
//			integer = integer + (integer % 5 < 3 ? -integer % 5 : 5 - integer % 5);
//		}
//		return integer;
//	}
//
//	public String getHoraTxt() {
//		return getText(getLblTime());
//	}
//
//	public void clicaOk() {
//		click(getBtnOk());
//	}

}
