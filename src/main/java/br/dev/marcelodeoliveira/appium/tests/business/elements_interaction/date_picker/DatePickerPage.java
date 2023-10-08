package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.date_picker;

import java.util.List;

import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BasePage;
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

	public MobileElement getBtnDate() {
		return btnDate;
	}


	public List<MobileElement> getListBtnDias() {
		return listBtnDias;
	}

}
