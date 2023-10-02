package br.dev.marcelodeoliveira.appium.tests.model.pages;

public class SwipeListPage extends BasePage {

	// THIS PARTICULAR PAGE DEMANDS DYNAMISM FOR GATHERING ELEMENTS
	// TODO: THINK ABOUT A BETTER STRATEGY FOR MOVING DYNAMISM TO LOGIC AND
	// CHECKIF THIS CLASS SHOULD STILL EXIST
	public String getSwipeBarXpathByIndex(String index) {
		return String.format("//android.widget.TextView[contains(@text, 'Opção %s')]", index);
	}

	public String getOptionSignalFrame(String index, String signal) {
		return String.format(
				"//android.widget.TextView[contains(@text, 'Opção %s')]/../../following-sibling::*//*[@text='%s']",
				index, signal);
	}



}
