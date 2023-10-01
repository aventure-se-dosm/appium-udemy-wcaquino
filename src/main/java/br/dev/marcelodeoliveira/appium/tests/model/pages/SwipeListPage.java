package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class SwipeListPage extends BasePage {

	enum Signal {
		POSITIVO("+"), NEGATIVO("-");

		private String signal;

		private Signal(String signal) {
			this.signal = signal;
		};

		public String getsignal() {
			return this.signal;
		}

		public String getsignalBetweenBrackets() {
			return String.format("(%s)", getsignal());
		}

		public static Signal getValueOf(String signal) {
			return Signal.valueOf(signal.toUpperCase());
		}

		public static List<String> getValues() {
			return Arrays.asList(Signal.values()).stream().map(signal -> signal.getsignal())
					.collect(Collectors.toList());
		}
	}

//	private String getOptByXpath(Integer index) {
//		return getOptByXpath(index.toString());
//	}
	private String getSwipeBarXpathByIndex(String index) {
		return String.format("//android.widget.TextView[contains(@text, 'Opção %s')]", index);
	}

	private String getOptionSignalFrame(String index, String signal) {
		return String.format(
				"//android.widget.TextView[contains(@text, 'Opção %s')]/../../following-sibling::*//*[@text='%s']",
				index, signal);
	}

//	private String getOptionAndSignalBaseXpath(String index, String signal) {
//		return String.format("//android.widget.TextView[contains(@text, 'Opção %s %s')]", index, signal);
//	}
//
//	private String getSignalXpath() {
//		return ("//android.widget.TextView[contains(@text, '(%s)')]");
//	}

	private MobileElement getOptElelmByXpath(String index) {

		return getElement(By.xpath(getSwipeBarXpathByIndex(index)));
	}

	public String swipeEsquerdaComCliqueNoSinal(String index, String signal) {

		swipeLeft(getOptElelmByXpath(index).getCenter());
		clickByIndexAndsignal(index, signal);
		return getSwipeBarText(index);
	}

	public String getSwipeBarText(String index) {
		return getText(getElement(By.xpath(getSwipeBarXpathByIndex(index))));
	}

	private void clickByIndexAndsignal(String index, String signal) {

		Signal s = Signal.getValueOf(signal);
		switch (s) {
		case POSITIVO: {
			// provisory: get a proper offset by the itself element dimensions.
			tap(getElement(By.xpath(getOptionSignalFrame(index, Signal.POSITIVO.getsignalBetweenBrackets())))
					.getLocation().moveBy(10, 1));
			break;
		}
		case NEGATIVO: {
			click(getElement(By.xpath(getOptionSignalFrame(index, Signal.NEGATIVO.getsignalBetweenBrackets()))));
			break;
		}
		}

	}

	public String swipeDireita(String index) {
		swipeRight(getOptElelmByXpath(index).getCenter());
		return getSwipeBarText(index);
	}

}
