package br.dev.marcelodeoliveira.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	private static AndroidDriver<MobileElement> androidDriver, testDriver;
	private static WebDriver webDriver;
	private static DesiredCapabilities desiredCapabilities;
	private static MutableCapabilities caps, sauceOptions;

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
		setBasicCapabilities();
		desiredCapabilities.setCapability("fullReset", false);
		desiredCapabilities.setCapability("noReset", true);
	}

	public static void setBasicCapabilities() {
		desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
	}

	public static void setTestDriverCapabilities() {

		setTestCapsCapabilites();
		setSouceTestCapabilites();
		caps.setCapability("sauce:options", sauceOptions);
	}

	public static void setTestCapsCapabilites() {
		caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk"); // The filename of the mobile app
		
		
		 caps.setCapability("deviceName", "Android GoogleAPI Emulator");
		 caps.setCapability("platformVersion", "12.0");
		caps.setCapability("automationName", "uiautomator2");
	}

	public static void setSouceTestCapabilites() {
		sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-markeepgoin-8443f");
		sauceOptions.setCapability("accessKey", "9ba09152-a3ec-46b4-bf4b-96448a62a0ac");
		sauceOptions.setCapability("build", "appium-build-T9BD9");
		sauceOptions.setCapability("name", "CTAppium");
		// sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
	}

	public static void setDefaultCapabilitiesCalc() {
		setBasicCapabilities();
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

	private static boolean isTestDriverNull() {
		return testDriver == null;
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
			androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void setupTestDriver() {

		testDriver = null;
		setTestDriverCapabilities();
		try {
			testDriver = new AndroidDriver<MobileElement>(
					new URL("https://oauth-markeepgoin-8443f:9ba09152-a3ec-46b4-bf4b-96448a62a0ac@ondemand.us-west-1.saucelabs.com:443/wd/hub"), getTestCapsCapabilities());
			
			 testDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static Capabilities getTestCapsCapabilities() {
		boolean c = caps == null;
		return caps;
	}

	public static Capabilities getTestSauceOptionCapabilities() {
		return sauceOptions;
	}

	public static AndroidDriver<MobileElement> getDriver() {
		if (isDriverNull()) {
			setupDriver();
		}
		return androidDriver;
	}

	public static AndroidDriver<MobileElement> getTestDriver() {
		if (isTestDriverNull()) {
			setupTestDriver();
		}
		return testDriver;
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
		setDriverNull(getDriver());
	}

	public static void killWebDriver() {
		if (!isWebDriverNull())
			webDriver.quit();
		setDriverNull(getWebDriver());
	}

	public static void killTestDriver() {
		if (!isWebDriverNull())
			webDriver.quit();
		setDriverNull(getTestDriver());
	}
	
	public static void killEveryDriver() {
		killDriver();
		killWebDriver();
		killTestDriver();
	}

	public static void setDriverNull(WebDriver driver) {
		driver = null;
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
