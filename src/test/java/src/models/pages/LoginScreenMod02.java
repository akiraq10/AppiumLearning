package src.models.pages;

import io.appium.java_client.AppiumDriver;
import src.models.components.global.BottomNavComponent;
import src.models.components.login.LoginFormComponent;
import src.models.components.login.LoginFormComponentMod2;

public class LoginScreenMod02 {


    private final AppiumDriver appiumDriver;
    public LoginScreenMod02(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public BottomNavComponent bottomNavComponent(){
        return new BottomNavComponent(appiumDriver);
    }

    public LoginFormComponentMod2 loginFormComponent(){
        return new LoginFormComponentMod2(appiumDriver);
    }
}
