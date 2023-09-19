package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DatePickerPage extends BasePage {

	@AndroidFindBy(xpath = "//*[@content-desc='switch']/following-sibling::android.view.ViewGroup/android.widget.TextView")
	private MobileElement btnDate;

	@AndroidFindBy(xpath = "//android.view.View[@text='20']")
//	@AndroidFindBy(accessibility = "20 janeiro 2000")
	private MobileElement btnDia20;

	@AndroidFindAll(@AndroidBy(xpath = "//android.view.View[@id='android:id/month_view']/android.view.View"))
//	@AndroidFindBy(accessibility = "20 janeiro 2000")
	private List<MobileElement> listBtnDias;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOk;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancelar;

	public void clicaData() {
		click(btnDate);
	}

	public void clicaOk() {
		click(btnOk);
	}

	public void escolheDia(Integer dia) {
		// click(btnDia20);
		String s = dia.toString();
		// List<MobileElement> l = getListBtnDias();
		// Assert.assertEquals(l.size(), 1);
		click(getListBtnDias().stream().filter(day -> day.getText().contains(s)).findFirst().get());
	}

	private List<MobileElement> getListBtnDias() {
		List<WebElement> s = getMobileElements(By.xpath("//android.view.View[@resource-id='android:id/month_view']/*"));
		Assert.assertTrue(s.size() > 0);
		return s.stream().map(elem -> (MobileElement) elem).collect(Collectors.toList());
	}

	public void escolheDia20() {
		click(btnDia20);
	}

	public String getLblDateText() {

		String txt = getText(btnDate);
		return txt;
	}

}
