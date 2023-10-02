package br.dev.marcelodeoliveira.appium.tests.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import br.dev.marcelodeoliveira.appium.tests.model.pages.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.pages.SwipeListPage;

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

		swipeLeft(page.getOptElelmByXpath(index).getCenter());
		clickByIndexAndsignal(index, signal);
		return page.getSwipeBarText(index);
	}

	private void clickByIndexAndsignal(String index, String signal) {

		Signal s = Signal.getValueOf(signal);
		switch (s) {
		case POSITIVO: {
			// provisory: get a proper offset by the itself element dimensions.
			// TODO: Refactor it! Those elements could be better and clearly described; and
			// gathered by simpler ways.
			// Seize the new layer Logic separated from Page's.
			tap(getElement(By.xpath(page.getOptionSignalFrame(index, Signal.POSITIVO.getsignalBetweenBrackets())))
					.getLocation().moveBy(10, 1));
			break;
		}
		case NEGATIVO: {
			click(page.getElement(
					By.xpath(page.getOptionSignalFrame(index, Signal.NEGATIVO.getsignalBetweenBrackets()))));
			break;
		}
		}

	}

	public String swipeDireita(String index) {
		swipeRight(page.getOptElelmByXpath(index).getCenter());
		return page.getSwipeBarText(index);
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SwipeListPage();

	}

}
