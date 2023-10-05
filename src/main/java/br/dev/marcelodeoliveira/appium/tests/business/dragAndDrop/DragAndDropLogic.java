package br.dev.marcelodeoliveira.appium.tests.business.dragAndDrop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;

public class DragAndDropLogic extends BaseLogic {

	private DragAndDropPage page;

	public String[] getExpectedInitialState() {
		String[] a = { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para",
				"qualquer local desejado." };

		return a;
	}

	public String[] getExpectedIntermediateState() {

		String[] a = { "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta",
				"qualquer local desejado." };
		return a;
	}

	public String[] getExpectedFinalState() {
		String[] a = { "Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta",
				"qualquer local desejado." };

		return a;
	}

	public String[] getCurrentState() {

		// page.getFlagElementBy();

		ArrayList<String> labels = (ArrayList<String>) waitUntilElementListToBeVisible(getListAllMovableElements())
				.stream().map(elem -> getText(elem).toString()).collect(Collectors.toList());

		Assert.assertTrue(labels.size() > 0);
		return labels.toArray(new String[labels.size()]);
	}

	// should be abstracted to a wait-and-return the List when all of its desired
	// elements are displayed at that time.
	private List<WebElement> getListAllMovableElements() {
		waitUntilElementToBeVisible(page.getFlagElementBy());
		return page.getListAllMovableElements();
	}

	public void drag(String elemOriginTxt, String elemDestinationTxt) {
		drag(getMovableElement(elemOriginTxt), getMovableElement(elemDestinationTxt));
	}

	private WebElement getMovableElement(String elemName) {

		// TODO: stream processings should be better on BaseLogic as proper individual
		// methods!

		return page.getListAllMovableElements().stream().filter(elem -> elem.getAttribute("text").equals(elemName))
				.findAny().get();
	}

//	private WebElement getMovableElement(String elemName) {
//
//		return getListAllMovableElements().stream().filter(elem -> elem.getAttribute("text").equals(elemName)).findAny()
//				.get();
//	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new DragAndDropPage();

	}

}