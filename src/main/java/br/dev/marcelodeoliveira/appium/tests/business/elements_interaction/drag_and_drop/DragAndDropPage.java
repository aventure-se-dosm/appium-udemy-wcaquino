package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.drag_and_drop;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.dev.marcelodeoliveira.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragAndDropPage extends BasePage {
	public DragAndDropPage() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
		wait = new WebDriverWait(getDriver(), 15L);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Esta']")
	private MobileElement flagElement;

	@AndroidFindAll(@AndroidBy(xpath = "//android.widget.TextView[contains(text(),'')]"))
	private List<WebElement> ListAllMovableTxt;

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

	public MobileElement getFlagElementBy() {
		return this.flagElement;
	}

	public List<WebElement> getListAllMovableElements() {

		return ListAllMovableTxt;
	}

//	public String[] getCurrentState() {
//
//		waitUntilWebElementToBeVisible(flagElementBy);
//
//		ArrayList<String> labels = (ArrayList<String>) waitUntilElementListToBeVisible(getListAllMovableElements())
//				.stream().map(elem -> getText(elem).toString()).collect(Collectors.toList());
//
//		Assert.assertTrue(labels.size() > 0);
//		return labels.toArray(new String[labels.size()]);
//	}

//	public void drag(String elemOriginTxt, String elemDestinationTxt) {
//		drag(getMovableElement(elemOriginTxt), getMovableElement(elemDestinationTxt));
//	}

//	public By getFlagElementBy() {
//		// TODO Auto-generated method stub
//		return this.flagElementBy;
//	}

}