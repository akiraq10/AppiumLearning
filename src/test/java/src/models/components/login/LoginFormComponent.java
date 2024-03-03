package src.models.components.login;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFormComponent {
    private final AppiumDriver appiumDriver;

    public LoginFormComponent(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    private static final By usernameSel = new AppiumBy.ByAccessibilityId("");
    private static final By pwdSel = new AppiumBy.ByAccessibilityId("");
    private static final By loginBtnSel = new AppiumBy.ByAccessibilityId("");

    public WebElement usernameElem(){
        return appiumDriver.findElement(usernameSel);
    }

    public WebElement pwdElem(){
        return appiumDriver.findElement(pwdSel);
    }
    public WebElement loginBtnElem(){
        return appiumDriver.findElement(loginBtnSel);
    }
}
