package br.dev.marcelodeoliveira.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

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
		desiredCapabilities.setCapability("fullReset", false);
		desiredCapabilities.setCapability("noReset", true);
	}

	private static boolean isDriverNull() {
		return driver == null;
	}

	public static void addCapability(String key, String value) {
		getCapabilities().setCapability(key, value);
	}

	public static void setupDriver() {
		driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http:/0.0.0.0:4723/wd/hub"), getCapabilities());
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
			driver.quit();
		setDriverNull();
	}

	private static void setDriverNull() {
		driver = null;
	}

}
