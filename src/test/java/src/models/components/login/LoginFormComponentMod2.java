package src.models.components.login;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFormComponentMod2 {
    private final AppiumDriver appiumDriver;

    public LoginFormComponentMod2(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    private static final By usernameSel = new AppiumBy.ByAccessibilityId("");
    private static final By pwdSel = new AppiumBy.ByAccessibilityId("");
    private static final By loginBtnSel = new AppiumBy.ByAccessibilityId("");

    public LoginFormComponentMod2  inputUsernameElem(String username){
         appiumDriver.findElement(usernameSel).sendKeys(username);
         return this;
    }

    public LoginFormComponentMod2  inputPwdElem(String pwd ){
         appiumDriver.findElement(pwdSel).sendKeys(pwd);
        return this;
    }
    public LoginFormComponentMod2 clickLoginBtnElem(){
         appiumDriver.findElement(loginBtnSel).click();
        return this;
    }
}
