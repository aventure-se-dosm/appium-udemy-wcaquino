package br.dev.marcelodeoliveira.appium.tests.logic;

import org.junit.Assert;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.TimePickerPage;

public class TimePickerLogic extends BaseLogic {

	private TimePickerPage page;

//	private By listRdbHourMinute = By.xpath("//*[@resource-id='android:id/radial_picker']/*");
//	private TimePickerPage page;
//
//	private By getListRdbHourMinute() {
//		return listRdbHourMinute;
//	}

//	public MobileElement getHora(Integer hour) {
//		return getMobileElementTextByAttribute(getListRdbHourMinute(), MobileElementAttribute.CONTENT_DESC, hour);
//	}

//	private MobileElement getMobileElementTextByAttribute(By by, MobileElementAttribute attribute, Object value) {
//		List<WebElement> listElem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
//		return (MobileElement) listElem.stream()
//				.filter(elem -> elem.getAttribute(attribute.getName()).equals(value.toString())).findFirst().get();
//	}

//	public MobileElement getMinuto(Integer minuto) {
//		return getMobileElementTextByAttribute(getListRdbHourMinute(), MobileElementAttribute.CONTENT_DESC, minuto);
//	}

	public Object getHoraTxt(Integer hora) {
		return super.getText(page.getHora(hora));
	}

	public Object getMinutoTxt(Integer minuto) {
		return super.getText(page.getMinuto(minuto));
	}

	public void selecionaHora(Integer hour, Integer minute) {
		click(page.getLblTime());
		click(page.getBtnKeyboardInput());
		writeText(page.getTxtHour(), hour.toString());
		writeText(page.getTxtMinute(), minute.toString());

	}

	public void selecionaHoraSimples(Integer hour, Integer minute) {
		int roundMinute = roundBy5(minute);
		System.out.println(minute);
		Assert.assertTrue(super.getAssertionMessage(50, roundMinute), 50 == roundMinute);
		click(page.getLblTime());
		click(page.getHora(hour));
		click(page.getMinuto(minute));

	}

	private Integer roundBy5(Integer integer) {
		if (integer % 5 != 0) {
			integer = integer + (integer % 5 < 3 ? -integer % 5 : 5 - integer % 5);
		}
		return integer;
	}

	public String getHoraTxt() {
		return getText(page.getLblTime());
	}

	public void clicaOk() {
		click(page.getBtnOk());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new TimePickerPage();

	}

}
