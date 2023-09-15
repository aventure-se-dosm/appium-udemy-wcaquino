package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.support.PageFactory;

import br.dev.marcelodeoliveira.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculadoraPage extends BasePage {

	public CalculadoraPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()), this);
	}

	@AndroidFindBy(id = "com.google.android.calculator:id/op_add")
	private MobileElement btnAdd;

	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private MobileElement btnEquals;

	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private MobileElement lblResult;

	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
	private MobileElement btnMinus;

	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private MobileElement btnTimes;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div")
	private MobileElement btnDividedTo;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_pct")
	private MobileElement btnPercent;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sqrt")
	private MobileElement btnSqrt;
	@AndroidFindBy(id = "com.google.android.calculator:id/del")
	private MobileElement btndel;
	@AndroidFindBy(id = "com.google.android.calculator:id/clr")
	private MobileElement btnClear;

	public void simpleSum(Integer a, Integer b) {

		selectNumber(a);
		pressAdd();
		selectNumber(b);
		pressEquals();
	}

	private void selectNumber(Integer a) {
		click(DriverFactory.getDriver().findElementByAccessibilityId(a.toString()));
	}

	private void pressAdd() {
		click(getBtnAdd());
	}

	private void pressMinus() {
		click(getBtnMinus());
	}

	private MobileElement getBtnMinus() {

		return btnMinus;
	}

	private void pressTimes() {
		click(getBtnTimes());
	}

	private MobileElement getBtnTimes() {

		return btnTimes;
	}

	private void pressDividedTo() {
		click(getBtnDividedTo());
	}

	private MobileElement getBtnDividedTo() {

		return btnDividedTo;
	}

	private void pressSqrt() {
		click(getBtnSqrt());
	}

	private MobileElement getBtnSqrt() {

		return btnSqrt;
	}

	private MobileElement getBtnAdd() {
		return btnAdd;
	}

	private MobileElement getBtnEquals() {
		return btnEquals;
	}

	private MobileElement getLblResult() {
		return lblResult;
	}

	private void pressEquals() {
		click(getBtnEquals());
	}

	private MobileElement getBtnPercent() {
		return btnPercent;
	}

	private MobileElement getBtndel() {
		return btndel;
	}

	private MobileElement getBtnClear() {
		return btnClear;
	}

	public String getResult() {
		return getText(getLblResult());
	}

}
