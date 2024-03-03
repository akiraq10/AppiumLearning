package src.api_learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import src.Driver.DriverFactory;
import src.Driver.Platform;
import src.models.components.login.LoginFormComponent;
import src.models.pages.LoginScreenMod01;

public class LoginTestMod01 {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try{
            LoginScreenMod01 loginScreen =new LoginScreenMod01(appiumDriver);
            loginScreen.bottomNavComponent().loginIconElem().click();

            LoginFormComponent loginFormComponent =loginScreen.loginFormComponent();


            loginFormComponent.usernameElem().sendKeys("kkk@gmail.com");
            loginFormComponent.pwdElem().sendKeys("qwe");
            loginFormComponent.loginBtnElem().click();


        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
