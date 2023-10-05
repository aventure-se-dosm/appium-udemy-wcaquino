package br.dev.marcelodeoliveira.appium.tests.business.swipeList;

import br.dev.marcelodeoliveira.appium.core.BasePage;

public class SwipeListPage extends BasePage {

	// THIS PARTICULAR PAGE DEMANDS DYNAMISM FOR GATHERING ELEMENTS
	// TODO: THINK ABOUT A BETTER STRATEGY FOR MOVING DYNAMISM TO LOGIC AND
	// CHECKIF THIS CLASS SHOULD STILL EXIST

	private final String optionSignalElementStringPattern = "//android.widget.TextView[contains(@text, 'Opção %s')]/../../following-sibling::*//*[@text='%s']";
	private final String swipeElementStringPattern = "//android.widget.TextView[contains(@text, 'Opção %s')]";

	public String getSwipeElementStringPattern() {
		return swipeElementStringPattern;
	}

	public String getOptionSignalElementStringPattern() {
		return optionSignalElementStringPattern;
	}

}
