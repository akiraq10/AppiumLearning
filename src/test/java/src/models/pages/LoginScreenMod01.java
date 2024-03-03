package src.models.pages;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import src.models.components.global.BottomNavComponent;
import src.models.components.login.LoginFormComponent;

public class LoginScreenMod01 {


    private final AppiumDriver appiumDriver;
    public LoginScreenMod01(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomNavComponent bottomNavComponent(){
        return new BottomNavComponent(appiumDriver);
    }

    public LoginFormComponent loginFormComponent(){
        return new LoginFormComponent(appiumDriver);
    }
}
