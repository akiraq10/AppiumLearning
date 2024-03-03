package src.api_learning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.Driver.DriverFactory;
import src.Driver.Platform;

import java.time.Duration;

public class LoginFormTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver appiumDriver= DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to login form
            WebElement navLoginBtnElem= appiumDriver.findElement(By.id("Login"));
            navLoginBtnElem.click();
            //find login form element
            WebElement emailInputElem= appiumDriver.findElement(By.id("input_email"));
            WebElement pwdInputElem= appiumDriver.findElement(By.id("input_pwd"));
            WebElement loginBtnElem= appiumDriver.findElement(By.id("button_LOGIN"));

            //Interact with login form|fill username and pwd and click on login btn
            emailInputElem.sendKeys("kkk@gmail./com");
            pwdInputElem.sendKeys("qwe");
            loginBtnElem.click();

            //Verification
            WebDriverWait wait=new WebDriverWait(appiumDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));

            WebElement loginDialogTitleElem= appiumDriver.findElement(By.id("android:id/alertTitle"));
            System.out.println(loginDialogTitleElem.getText());

            //Print the dialog content

            //Debug purpose only
            Thread.sleep(3000);


        }catch (Exception e){
            e.printStackTrace();
        }
        appiumDriver.quit();

    }
}
