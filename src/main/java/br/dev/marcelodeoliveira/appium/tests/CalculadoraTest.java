package br.dev.marcelodeoliveira.appium.tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {
 
       @Test
       public void calculadoraSomaTest() throws MalformedURLException {

              DesiredCapabilities desiredCapabilities;
       
              desiredCapabilities = new DesiredCapabilities();

              desiredCapabilities.setCapability("platformName", "Android");
              desiredCapabilities.setCapability("deviceName", "emulator-5554");
              desiredCapabilities.setCapability("automationName", "uiautomator2");
              desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
              desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
              desiredCapabilities.setCapability("noReset", true);
    	      desiredCapabilities.setCapability("fullReset", false);

               AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                             desiredCapabilities);
               
               driver.manage().timeouts().implicitlyWait(10L,  TimeUnit.SECONDS);


               MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("2");
               el2.click();
               
               MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("plus");
               
               el3.click();
               MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("2");
               
               el4.click();
               MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
                              
               el5.click();
               MobileElement el6 = (MobileElement) driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
               
               //Assert.assertSame(el2, el4); //fail: their references don't point to the same object;
               Assert.assertEquals(el2, el4);
               Assert.assertEquals(el2.getAttribute("content-desc"), "2", el2.getAttribute("content-desc")); 
               Assert.assertEquals(el3.getAttribute("content-desc"), "plus", el3.getAttribute("content-desc"));
               Assert.assertEquals(el4.getAttribute("content-desc"), "2", el4.getAttribute("content-desc"));
               Assert.assertEquals(el5.getAttribute("content-desc"), "equals", el5.getAttribute("content-desc"));
               Assert.assertEquals(el6.getAttribute("content-desc"), "4", el6.getText());
               
               driver.quit();
       }

}
