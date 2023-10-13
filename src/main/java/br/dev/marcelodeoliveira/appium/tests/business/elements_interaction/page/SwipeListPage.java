package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page;

import br.dev.marcelodeoliveira.appium.core.BasePage;

public class SwipeListPage extends BasePage {

	private final String optionSignalElementStringPattern = "//android.widget.TextView[contains(@text, 'Opção %s')]/../../following-sibling::*//*[@text='%s']";
	private final String swipeElementStringPattern = "//android.widget.TextView[contains(@text, 'Opção %s')]";

	public String getSwipeElementStringPattern() {
		return swipeElementStringPattern;
	}

	public String getOptionSignalElementStringPattern() {
		return optionSignalElementStringPattern;
	}

}
