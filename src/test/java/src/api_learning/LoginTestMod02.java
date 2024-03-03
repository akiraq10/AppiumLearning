package src.api_learning;

import io.appium.java_client.AppiumDriver;
import src.Driver.DriverFactory;
import src.Driver.Platform;
import src.models.components.login.LoginFormComponent;
import src.models.components.login.LoginFormComponentMod2;
import src.models.pages.LoginScreenMod02;


public class LoginTestMod02 {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try{
            LoginScreenMod02 loginScreen =new LoginScreenMod02(appiumDriver);
            loginScreen.bottomNavComponent().loginIconElem().click();

            LoginFormComponentMod2 loginFormComponent =loginScreen.loginFormComponent();


            loginFormComponent
                    .inputUsernameElem("kkk@gmail.com")
                    .inputPwdElem("qwe")
                    .clickLoginBtnElem();



        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
