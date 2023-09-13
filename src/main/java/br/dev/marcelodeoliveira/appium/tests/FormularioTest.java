
package br.dev.marcelodeoliveira.appium.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {

	private AndroidDriver<MobileElement> driver = null;
	private DesiredCapabilities desiredCapabilities;

	@Before
	public void setupTest() throws MalformedURLException {
		setupDesiredCapabilities();
		setupDriver();
	}

	void setupDesiredCapabilities() {
		this.desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("fullReset", "false");
		desiredCapabilities.setCapability("noReset", "false");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,

				// TODO: make the absolutePath transparent for the user, once relative paths
				// haven't worked yet.
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");

	}

	private void setupDriver() throws MalformedURLException {

		this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				getDesiredCapabilities());

		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
	}

	private boolean isDriverNull() {
		return this.driver == null;
	}

	private AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		return this.driver;
	}

	private DesiredCapabilities getDesiredCapabilities() {
		if (desiredCapabilities == null)
			setupDesiredCapabilities();
		return desiredCapabilities;
	}

	@Test
	public void devePreencherCampoTeste() throws MalformedURLException {

		String txtName = "Wagner";

		// somewhat verbose
		MobileElement formularioOption;
		formularioOption = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
		formularioOption.click();

		MobileElement nameField;
		nameField = driver.findElement(MobileBy.xpath("//android.widget.EditText[@content-desc='nome']"));
		nameField.sendKeys(txtName);
		Assert.assertEquals(txtName, nameField.getText());

		getDriver().quit();
	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		String txtName = "Wagner";
		String spinnerGameConsoleOption = "PS4";

		MobileElement formularioOption;
		formularioOption = driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
		formularioOption.click();

		MobileElement nameField;
		nameField = driver.findElement(MobileBy.AccessibilityId("nome"));
		nameField.sendKeys(txtName);

		MobileElement spinner;
		spinner = driver.findElement(MobileBy.xpath("//android.widget.Spinner[@content-desc='console']"));
		spinner.click();

		MobileElement option;
		option = driver.findElement(MobileBy
				.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", spinnerGameConsoleOption)));
		option.click();

		MobileElement switchHour;
		switchHour = driver.findElement(MobileBy.AccessibilityId("switch"));
		if (switchHour.getAttribute("checked").equals("true"))
			switchHour.click();

		MobileElement chkHour;
		chkHour = driver.findElement(MobileBy.AccessibilityId("check"));
		if (chkHour.getAttribute("checked").equals("false"))
			chkHour.click();

		Assert.assertEquals(txtName, nameField.getText());
		Assert.assertEquals(switchHour.getAttribute("checked"), "false");
		Assert.assertEquals(chkHour.getAttribute("checked"), "true");
		Assert.assertEquals(txtName, nameField.getText());

		finishTest();
	}

	@After
	public void finishTest() {
		driver.quit();
	}

}
