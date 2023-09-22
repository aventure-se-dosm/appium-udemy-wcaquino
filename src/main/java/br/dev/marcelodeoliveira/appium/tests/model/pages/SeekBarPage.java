package br.dev.marcelodeoliveira.appium.tests.model.pages;

import org.junit.Assert;
import org.openqa.selenium.Rectangle;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.getDriver;

public class SeekBarPage extends BasePage {

	@AndroidFindBy(id = "slid")
	private MobileElement seekBar;
	


	private MobileElement getSeekBar() {
		return seekBar;
	}

	public void moveSeekBarParaPorcentagemEscolhida(Integer porcentagem) {
		Assert.assertFalse(porcentagem > 0 || porcentagem < 100);
		
//		//hardcoda o TouchActions aqui pra ver se funfa e depois abstrai pfv
// new TouchAction<>(getDriver())
//				.press(PointOption.point(getElementCenter(getSeekBar()))
//						.wait(500)
						
					
		
	}
	
	public void moveSeekBarParaPorcentagemEscolhida(Float porcentagem) {
		moveSeekBarParaPorcentagemEscolhida((porcentagem *= 100).intValue());
	}
	
	
}
