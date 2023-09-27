package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;



public class SwipeListPage extends BasePage {
	

	 enum Sinal {
		POSITIVO("+"),
		NEGATIVO("-");
		
		private String sinal;
		private Sinal(String sinal) {
			this.sinal = sinal;
		};
		
		//como ocultar?
		public String getSinal() {
			return this.sinal;
		}
		public String getSinalBetweenBrackets() {
			return String.format("(%s)", getSinal());
		}
	}
//	private String getOptByXpath(Integer index) {
//		return getOptByXpath(index.toString());
//	}
	 private String getOptionBaseXpath() {
		 return ("//android.widget.TextView[contains(@text, 'Opção %s')]");
	 }
	 private String getOptionAndSignalBaseXpath() {
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
		return getElement(
				By.xpath(String.format("//android.widget.TextView[contains(@text, 'Opção %s')]", index)));
	}

	public void swipeEsquerda(String index, String sinal) {
		swipeLeft(getOptElelmByXpath(index).getCenter());
		 //click(element);
	}

	public void swipeDireita(String index, String sinal) {
		swipeRight(getOptElelmByXpath(index).getCenter());
	}

}
