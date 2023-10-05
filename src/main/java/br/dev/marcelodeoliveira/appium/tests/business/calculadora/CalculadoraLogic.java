package br.dev.marcelodeoliveira.appium.tests.business.calculadora;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.core.DriverFactory;

public class CalculadoraLogic extends BaseLogic {

	private CalculadoraPage page;

	public void simpleSum(Integer a, Integer b) {

		selectNumber(a);
		pressAdd();
		selectNumber(b);
		pressEquals();
	}

	private void selectNumber(Integer a) {
		if (a < 0) {
			pressMinus();
			a = invertNumber(a);
		}
		click(DriverFactory.getDriver().findElementByAccessibilityId(a.toString()));
	}

	private Integer invertNumber(Integer a) {
		a = -a;
		return a;
	}

	private void pressAdd() {
		click(page.getBtnAdd());
	}

	private void pressMinus() {
		click(page.getBtnMinus());
	}

//	private MobileElement getBtnMinus() {
//
//		return btnMinus;
//	}

	private void pressMult() {
		click(page.getBtnTimes());
	}
//
//	private MobileElement getBtnTimes() {
//
//		return btnTimes;
//	}

	private void pressDividedTo() {
		click(page.getBtnDividedTo());
	}

	private void pressSqrt() {
		click(page.getBtnSqrt());
	}

	private void pressEquals() {
		click(page.getBtnEquals());
	}

	public String getResult() {
		return getText(page.getLblResult());
	}

	public void simpleSub(int a, int b) {
		selectNumber(a);
		pressMinus();
		selectNumber(b);
		pressEquals();
	}

	public void simpleMult(int a, int b) {
		selectNumber(a);
		pressMult();
		selectNumber(b);
		pressEquals();
	}

	public void simpleDiv(int a, int b) {
		selectNumber(a);
		pressDividedTo();
		selectNumber(b);
		pressEquals();
	}

	public void simpleSqrt(int a) {
		pressSqrt();
		selectNumber(a);
		pressEquals();
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new CalculadoraPage();

	}

}
