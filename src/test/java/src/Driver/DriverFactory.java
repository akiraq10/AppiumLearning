package src.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    public static AppiumDriver getDriver(Platform platform) throws InterruptedException {
        AppiumDriver driver ;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID, "g8s1");
        desiredCapabilities.setCapability(APP_PACKAGE, "g8s1");
        desiredCapabilities.setCapability(APP_ACTIVITY, "g8s1");

        URL appiumServer = null;
        try {
            appiumServer = new URL("https://localhost:43333/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumServer == null) {
            throw new RuntimeException("driver not null");
        }
        switch (platform){
            case ANDROID:
                driver=new AndroidDriver(appiumServer, desiredCapabilities);
                break;
            case IOS:
                driver=new IOSDriver(appiumServer,desiredCapabilities);
                break;
            default:
                throw new IllegalArgumentException("Plaform type can't be null");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }
}
