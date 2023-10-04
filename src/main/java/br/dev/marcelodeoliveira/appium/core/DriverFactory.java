package br.dev.marcelodeoliveira.appium.core;

import static br.dev.marcelodeoliveira.appium.core.DriverFactory.addCapability;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	private static AndroidDriver<MobileElement> androidDriver;
	private static WebDriver webDriver;
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
		desiredCapabilities.setCapability("fullReset", true);
		desiredCapabilities.setCapability("noReset", false);
	}
	public static void setDefaultCapabilitiesCalc() {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		addCapability("appPackage", "com.google.android.calculator");
		addCapability("appActivity", "com.android.calculator2.Calculator");
//		desiredCapabilities.setCapability("fullReset", true);
//		desiredCapabilities.setCapability("noReset", false);
	}

	public static void setAppAndAllowAppPermissionCapabilities() {
		addCapability(MobileCapabilityType.APP,
				"C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_2_0.apk");
		addCapability("appWaitPackage", "com.google.android.permissioncontroller");
		addCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
	}

	public static void setAppAndAllowAppPermissionCapabilities(String version) {
		String app_path_version = "C:/Users/MarcelodeOliveiraSan/Workspace/APPIUM/CursoAppium/src/main/resources/apks/CTAppium_"
				+ (version.replace(".", "_") + ".apk");
		addCapability(MobileCapabilityType.APP, app_path_version);
		if (version.equals("1.2")) {
			addCapability("appWaitPackage", "com.google.android.permissioncontroller");
			addCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
		}
	}

	private static boolean isDriverNull() {
		return androidDriver == null;
	}

	private static boolean isWebDriverNull() {
		return webDriver == null;
	}

	public static void addCapability(String key, Object value) {
		getCapabilities().setCapability(key, value);
	}

	public static void setupDriver() {
		androidDriver = null;
		try {
			androidDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), getCapabilities());
			androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver<MobileElement> getDriver() {
		if (isDriverNull()) {
			setupDriver();
		}
		return androidDriver;
	}

	public static AndroidDriver<MobileElement> getWebDriver() {
		if (isDriverNull()) {
			setupDriver();
		}
		return androidDriver;
	}

	public static void killDriver() {
		if (!isDriverNull())
			androidDriver.quit();
		setDriverNull();

	}

	public static void killWebDriver() {
		if (!isWebDriverNull())
			webDriver.quit();
		setWebDriverNull();
	}

	private static void setDriverNull() {
		androidDriver = null;
	}

	private static void setWebDriverNull() {
		webDriver = null;
	}

	public static void setupDriver(Class<? extends WebDriver> classDriver) {
		try {
			webDriver = classDriver.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
