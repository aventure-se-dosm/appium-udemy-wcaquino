package br.dev.marcelodeoliveira.appium.tests.model.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculadoraPage extends BasePage {

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

	public MobileElement getBtnMinus() {

		return btnMinus;
	}

	public MobileElement getBtnTimes() {

		return btnTimes;
	}

	public MobileElement getBtnDividedTo() {

		return btnDividedTo;
	}

	public MobileElement getBtnSqrt() {

		return btnSqrt;
	}

	public MobileElement getBtnAdd() {
		return btnAdd;
	}

	public MobileElement getBtnEquals() {
		return btnEquals;
	}

	public MobileElement getLblResult() {
		return lblResult;
	}
}
