package src.api_learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.Driver.DriverFactory;
import src.Driver.Platform;

import java.time.Duration;

public class HybridContext {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try{
            WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(5));
//            wait.until()

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
