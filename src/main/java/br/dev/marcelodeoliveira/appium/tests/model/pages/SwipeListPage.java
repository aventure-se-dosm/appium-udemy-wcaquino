package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class SwipeListPage extends BasePage {

	enum Signal {
		POSITIVO("+"), NEGATIVO("-");

		private String signal;

		private Signal(String signal) {
			this.signal = signal;
		};

		// como ocultar?
		public String getsignal() {
			return this.signal;
		}

		public String getsignalBetweenBrackets() {
			return String.format("(%s)", getsignal());
		}

		public static Signal getValueOf(String signal) {
			return Signal.valueOf(signal.toUpperCase());
		}
	}

//	private String getOptByXpath(Integer index) {
//		return getOptByXpath(index.toString());
//	}
	private String getOptionXpath(String index) {
		return String.format("//android.widget.TextView[contains(@text, 'Opção %s')]", index);
	}
	private String getOptionSignalFrame(String index, String signal) {
		return String.format("//android.widget.TextView[contains(@text, 'Opção %s')]/following-sibling::*[@text='%s']", index, signal);
	}

	private String getOptionAndSignalBaseXpath(String index) {
		return ("//android.widget.TextView[contains(@text, 'Opção %s (%s)')]");
	}

	private String getSignalXpath() {
		return ("//android.widget.TextView[contains(@text, '(%s)')]");
	}

	private MobileElement getOptElelmByXpath(String index) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getElement(By.xpath(getOptionXpath(index)));
	}

	public void swipeEsquerda(String index, String signal) {
		swipeLeft(getOptElelmByXpath(index).getCenter());
		clickByIndexAndsignal(index, signal);
	}

	private void clickByIndexAndsignal(String index, String signal) {
		switch (Signal.getValueOf(signal)) {
			case POSITIVO: {
				click(getElement(getOptElelmByXpath(index)));
				break;
			}
			case NEGATIVO: {
				
				break;
			}
		}
		;

	}

	public void swipeDireita(String index, String signal) {
		swipeRight(getOptElelmByXpath(index).getCenter());
	}

}
