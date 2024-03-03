package src.models.components.global;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.opentelemetry.api.internal.ApiUsageLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import src.Driver.AppPackage;

public class BottomNavComponent {

    private final AppiumDriver appiumDriver;
    private static final By loginIconSet= new AppiumBy.ByAccessibilityId("login");

    public BottomNavComponent(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebElement loginIconElem(){
        return appiumDriver.findElement(loginIconSet);
    }

    //Method 2 | introduce main interaction method
    public void clickOnLoginIcon(){
        appiumDriver.findElement(loginIconSet).click();
    }
}
