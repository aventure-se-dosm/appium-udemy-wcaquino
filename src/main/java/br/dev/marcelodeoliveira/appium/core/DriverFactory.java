package br.dev.marcelodeoliveira.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private static AndroidDriver<MobileElement> driver;
	private static DesiredCapabilities desiredCapabilities;

	public void setupTest() {
		setupDriver();
	}
	
	private static DesiredCapabilities getCapabilities() {
		if (isdesiredCapabilitiesNull()) {
			setDefaultCapabilities();
		}

		return desiredCapabilities;
	}

	private static boolean isdesiredCapabilitiesNull() {
		return desiredCapabilities == null;
	}

	public static void setDefaultCapabilities() {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("noReset", false);
		desiredCapabilities.setCapability("fullReset", false);
	}

	private static boolean isDriverNull() {
		return driver == null;
	}

	public static void addCapability(String key, String value) {
		getCapabilities().setCapability(key, value);
	}

	public static void setupDriver() {
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
			driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver<MobileElement> getDriver() {
		if (isDriverNull()) {
			setupDriver();
		}
		return driver;
	}

	public static void killDriver() {
		if (!isDriverNull())
			getDriver().quit();
		setDriverNull();
	}
	public static void tearDown() {
		if (!isDriverNull())
			getDriver().resetApp();
		setDriverNull();
	}

	private static void setDriverNull() {
		driver = null;
	}

}
