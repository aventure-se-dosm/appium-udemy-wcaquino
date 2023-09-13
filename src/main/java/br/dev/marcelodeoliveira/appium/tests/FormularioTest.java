
package br.dev.marcelodeoliveira.appium.tests;

import static br.dev.marcelodeoliveira.appium.tests.DriverFactory.addCapability;
import static br.dev.marcelodeoliveira.appium.tests.DriverFactory.getDriver;
import static br.dev.marcelodeoliveira.appium.tests.DriverFactory.setDefaultCapabilities;
import static br.dev.marcelodeoliveira.appium.tests.DriverFactory.setupDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest extends BaseTest {

//	private AndroidDriver<MobileElement> driver = null;
//	private DesiredCapabilities desiredCapabilities;
//
//	@Before
//	public void setupTest() throws MalformedURLException {
//		setupDesiredCapabilities();
//		setupDriver();
//	}
//
//	void setupDesiredCapabilities() {
//		this.desiredCapabilities = new DesiredCapabilities();
//
//		desiredCapabilities.setCapability("platformName", "Android");
//		desiredCapabilities.setCapability("deviceName", "emulator-5554");
//		desiredCapabilities.setCapability("automationName", "uiautomator2");
//		desiredCapabilities.setCapability("fullReset", "false");
//		desiredCapabilities.setCapability("noReset", "false");
//		desiredCapabilities.setCapability(MobileCapabilityType.APP,
//
//				// TODO: make the absolutePath transparent for the user, once relative paths
//				// haven't worked yet.
//				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
//
//	}
//
//	private void setupDriver() throws MalformedURLException {
//
//		this.driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
//				getDesiredCapabilities());
//
//		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
//	}
//
//
//	private AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
//		return this.driver;
//	}
//
//	private DesiredCapabilities getDesiredCapabilities() {
//		if (desiredCapabilities == null)
//			setupDesiredCapabilities();
//		return desiredCapabilities;
//	}

	@Before
	public void setupTest() {
		setDefaultCapabilities();
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		setupDriver();
	}

	@Test
	public void devePreencherCampoTeste() throws MalformedURLException {

		String txtName = "Wagner";

		// somewhat verbose
		MobileElement formularioOption;
		formularioOption = getDriver().findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']"));
		formularioOption.click();

		MobileElement nameField;
		nameField = getDriver().findElement(MobileBy.xpath("//android.widget.EditText[@content-desc='nome']"));
		nameField.sendKeys(txtName);
		Assert.assertEquals(txtName, nameField.getText());

	}

	@Test
	public void deveIteragirSwitchEScheckbox() throws MalformedURLException {

		MobileElement switchHour;
		switchHour = getDriver().findElement(MobileBy.AccessibilityId("switch"));
		if (switchHour.getAttribute("checked").equals("true"))
			switchHour.click();

		MobileElement chkDate;
		chkDate = getDriver().findElement(MobileBy.AccessibilityId("check"));
		if (chkDate.getAttribute("checked").equals("false"))
			chkDate.click();

		Assert.assertEquals(switchHour.getAttribute("checked"), "false");
		Assert.assertEquals(chkDate.getAttribute("checked"), "true");
	}

	@Test
	public void deveResolverDesafio() {

		final String TXT_USER_NAME = "Wagnão";

		By txtFormulario = MobileBy.xpath("//android.widget.TextView[@text='Formulário']");
		By txtName = MobileBy.AccessibilityId("nome");
		By spinner = MobileBy.AccessibilityId("console");
		By menuGame = MobileBy.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", "Nintendo Switch"));
		By switchHour = MobileBy.AccessibilityId("switch");
		By chkDate = MobileBy.AccessibilityId("check");
		By btnSalvar = MobileBy.xpath("//android.widget.TextView[@text='SALVAR']");
		By allVisibleText = MobileBy.className("android.widget.TextView");

		getDriver().findElement(txtFormulario).click();
		;
		getDriver().findElement(txtName).sendKeys(TXT_USER_NAME);
		getDriver().findElement(spinner).click();
		getDriver().findElement(menuGame).click();
		getDriver().findElement(switchHour).click();
		getDriver().findElement(chkDate).click();
		getDriver().findElement(btnSalvar).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> listTxtWidgetTextString = getDriver().findElements(allVisibleText).stream()
				.map(elem -> elem.getText()).filter(s -> s.contains(": ")).collect(Collectors.toList());

		Assert.assertTrue(
				listTxtWidgetTextString.containsAll(Arrays.asList("Nome: ".concat(TXT_USER_NAME), "Console: switch",
						"Slider: 25", "Switch: Off", "Checkbox: Marcado", "Data: 01/01/2000", "Hora: 12:00")));

	}
}
