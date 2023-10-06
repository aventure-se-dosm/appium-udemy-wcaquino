package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.swipe_list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SwipeListLogic extends BaseLogic {

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

	private SwipeListPage page;

	public String swipeEsquerdaComCliqueNoSinal(String index, String signal) {

		swipeLeft(getOptElelmByXpath(index).getCenter());
		clickByIndexAndsignal(index, signal);
		return getSwipeBarText(index);

	}

	public By getSwipeBarXpathByIndex(String index) {
		return By.xpath(String.format(page.getSwipeElementStringPattern(), index));
	}

	public By getOptionSignalFrame(String index, String signal) {
		return By.xpath(String.format(page.getOptionSignalElementStringPattern(), index, signal));

	}

	private void clickByIndexAndsignal(String index, String signal) {

		Signal s = Signal.getValueOf(signal);
		switch (s) {
		case POSITIVO: {
			tap(getElement(getOptionSignalFrame(index, Signal.POSITIVO.getsignalBetweenBrackets())).getLocation()
					.moveBy(10, 1));
			break;
		}
		case NEGATIVO: {

			click(getElement(getOptionSignalFrame(index, Signal.NEGATIVO.getsignalBetweenBrackets())));

			break;
		}
		}

	}

	public String swipeDireita(String index) {
		swipeRight(getOptElelmByXpath(index).getCenter());
		return getSwipeBarText(index);
	}

	public MobileElement getOptElelmByXpath(String index) {

		return getElement(getSwipeBarXpathByIndex(index));
	}

	public String getSwipeBarText(String index) {
		return getText(getElement(getSwipeBarXpathByIndex(index)));
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SwipeListPage();

	}

}
