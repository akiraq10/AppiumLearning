package src;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class AppiumLaunchTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver driver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("udid", "g8s1");
        desiredCapabilities.setCapability("appPackage", "g8s1");
        desiredCapabilities.setCapability("appActivity", "g8s1");

        URL appiumServer = null;
        try {
            appiumServer = new URL("https");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumServer == null) {
            throw new RuntimeException("driver not null");
        }
        driver = new AppiumDriver(appiumServer, desiredCapabilities);

        //Debuf pusponse only
        Thread.sleep(3000);


    }
}
