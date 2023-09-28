package br.dev.marcelodeoliveira.appium.tests.model.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;

public class DragAndDropPage extends BasePage {
	
	//@AndroidBy(xpath = "//android.widget.TextView[contains(text(),'Esta')]")
	By flagElementBy = By.xpath("//android.widget.TextView[@text='Esta']");
	
	@AndroidFindAll(@AndroidBy(xpath = "//android.widget.TextView[contains(text(),'')]"))
	List<WebElement> ListAllMovableTxt;

	private List<WebElement> getListAllMovableTxt() {
		return ListAllMovableTxt;
	}
	
	public String[] getExpectedInitialState() {
		String[] a = {"Esta","é uma lista","Drag em Drop!","Faça um clique longo,","e arraste para","qualquer local desejado."};
		return a;
	}

	public String[] getCurrentState() {
		// TODO Auto-generated method stub
waitUntilWebElementToBeVisible(flagElementBy);
		ArrayList<String> labels =   (ArrayList<String>) waitUntilElementListToBeVisible(getListAllMovableTxt())
				.stream()
				.map(elem ->  getText(elem).toString())
				.collect(Collectors.toList());
		
		Assert.assertTrue(labels.size() > 0);
		return labels.toArray(new String[labels.size()]);

				
		
		
	}

}
