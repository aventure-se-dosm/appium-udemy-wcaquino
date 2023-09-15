package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormularioPage extends BasePage {

	public FormularioPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Formulário']")
	private MobileElement formulario;

	@AndroidFindBy(accessibility = "nome")
	private MobileElement txtName;

	@AndroidFindBy(accessibility = "console")
	private MobileElement spinner;

	@AndroidFindBy(accessibility = "check")
	private MobileElement chkDate;

	@AndroidFindBy(accessibility = "switch")
	private MobileElement switchHour;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView")
	private List<MobileElement> menuGameConsoles;

	@AndroidFindBy(accessibility = "save")
	private MobileElement btnSalvar;

	@AndroidFindAll(value = { @AndroidBy(xpath = "//android.widget.TextView") })
	List<MobileElement> listAllTextView;

	public MobileElement getFormulario() {
		return formulario;
	}

	public MobileElement getTxtName() {
		return txtName;
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
		return getMenuGameConsoles()
				.stream()
				.filter(e -> e.getText().equalsIgnoreCase(console))
				.findFirst()
				.get();
	}

	private List<MobileElement> getMenuGameConsoles() {
		// TODO Auto-generated method stub
		return menuGameConsoles;
	}

	public MobileElement getBtnSalvar() {
		return btnSalvar;
	}

	public List<MobileElement> getListAllTextView() {
		return listAllTextView;
	}

	public void clicaFormulario() {

		click(getFormulario());
	}

	public void escreveNome(String txtNameString) {
		writeText(getTxtName(), txtNameString);
	}

	public void mudaSwitch(boolean status) {
		changeElementState(getSwitchHour(), status);
		Assert.assertEquals(true, isSwitchSelected());

	}

	public void mudaCheckbox(boolean status) {
		changeElementState(getChkDate(), status);
	}

	public boolean isCheckboxSelected() {
		return isElementChecked(getChkDate());
	}

	public boolean isSwitchSelected() {
		return isElementChecked(switchHour);
	}

	public void salvarForm() {

		click(getBtnSalvar());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void selecionaConsole(String selectedGameConsole) {
		click(getSpinner());
		click(getMenuGame(selectedGameConsole));
	}
	
	public List<String> getAllFormResponse(){
		return  getListAllTextView().stream()
				.map(elem -> elem.getText())
				.filter(s -> ((String) s).contains(": "))
				.collect(Collectors.toList());
	}

}