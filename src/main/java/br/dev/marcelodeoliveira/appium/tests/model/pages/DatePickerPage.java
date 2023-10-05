package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DatePickerPage extends BasePage {

	@AndroidFindBy(xpath = "//*[@content-desc='switch']/following-sibling::android.view.ViewGroup/android.widget.TextView")
	private MobileElement btnDate;

	@AndroidFindAll(@AndroidBy(xpath = "//android.view.View[@resource-id='android:id/month_view']/*"))
	private List<MobileElement> listBtnDias;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOk;

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancelar;

	public WebElement getBtnOk() {
		return btnOk;
	}

//
	public MobileElement getBtnDate() {
		return btnDate;
	}

//	public String getLblDateText() {
//		return getText(getBtnDate());
//	}

	public List<MobileElement> getListBtnDias() {
		return listBtnDias;
	}

//	public void clicaData() {
//		click(getBtnDate());
//	}

//	public void clicaOk() {
//		click(getBtnOk());
//	}
//
//	public void escolheDia(Integer dia) {
//		click(getListBtnDias().stream().filter(day -> day.getText().contains(dia.toString())).findFirst().get());
//	}

}
