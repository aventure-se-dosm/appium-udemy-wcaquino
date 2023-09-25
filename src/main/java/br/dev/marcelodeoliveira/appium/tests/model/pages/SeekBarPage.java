package br.dev.marcelodeoliveira.appium.tests.model.pages;



import org.junit.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class SeekBarPage extends BasePage {

	private static final int DEFAULT_OFFSET = 27;
	
	
	
	
	@AndroidFindBy(accessibility = "slid")
	private MobileElement seekBar;

	private MobileElement currentExtentionBar, BarCursor;
	
	private MobileElement getSeekBar() {
		waitUntilElementToBeVisible(seekBar);
		return seekBar;
	}

	
	public MobileElement getCurrentExtentionBar() {
		return getSeekBar().findElement(By.xpath("./android.view.ViewGroup[3]"));

	}
	
	public MobileElement getBarCursor() {
		return getSeekBar().findElement(By.xpath("./android.view.ViewGroup[1]"));
	}
	public void moveSeekBarParaPorcentagemEscolhida(Float porcentagem) {
		
		int maxCurrentBarLength = getWidth(getFullExtentionBar()) - getWidth(getBarCursor());
		Assert.assertTrue(maxCurrentBarLength == (1080-54));
//		if (startsWith1) {
//			Assert.assertTrue(porcentagem > 0f || porcentagem < 1f);
//			porcentagem /= (0.99f);
//			porcentagem /= (0.99f);
//		} else {
//			Assert.assertTrue(porcentagem >= 0f || porcentagem < 1f);
//		}
//		max
		
		
		
		
//		//hardcoda o TouchActions aqui pra ver se funfa e depois abstrai pfv
// new TouchAction<>(getDriver())
//				.press(PointOption.point(getElementCenter(getSeekBar()))
//						.wait(500)

	}

	private MobileElement getFullExtentionBar() {
		// TODO Auto-generated method stub
		waitUntilElementToBeVisible(super.getNestedElement(getSeekBar(), By.xpath(".//android.view.ViewGroup[2]")));
		return getSeekBar().findElement(By.xpath(".//android.view.ViewGroup[2]"));
	}



	public void tapByPercentage(Float porcentagem) {
		// this percentage doesn't include zero"
		int x, y;
		//porcentagem -= 0.01f;
		//porcentagem /= (0.99f);
		Point pointToClick = new Point(
				x = getSeekBar().getLocation().getX()
				
				+(int)((float)(getWidth(getSeekBar())*porcentagem)),
				
				y = getElementInteractableYAxisRange(seekBar));
		tap(pointToClick);
		System.out.println(pointToClick);

	}

}
