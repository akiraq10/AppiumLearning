package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import src.Driver.DriverFactory;
import src.Driver.Platform;

import java.time.Duration;
import java.util.Arrays;

public class SwipeVertically {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver appiumDriver= DriverFactory.getDriver(Platform.ANDROID);
        try {
            //Navigate to login form
            WebElement navLoginBtnElem= appiumDriver.findElement(By.id("Login"));
            navLoginBtnElem.click();

            //tricky thing

            //get mobile screen
            Dimension windowsSize =appiumDriver.manage().window().getSize();
            int screenHeight=windowsSize.getHeight();
            int screenWidth=windowsSize.getWidth();

            //Calculate Touch Point
            int xCenter = screenWidth/2;
            int xEndPoint = 50*screenWidth /100;
            int yStartPoint = 50*screenHeight /100;
            int yEndPoint = 10*screenHeight /100;

            //Convert point to coordinate
            PointOption startPoint= new PointOption<>().withCoordinates(xCenter,yStartPoint);
            PointOption endPoint= new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            //Touch action
//            TouchAction touchAction = new TouchAction(appiumDriver);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
            Sequence swipe = new Sequence(finger,1);

            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),xCenter,yStartPoint))
                    .addAction(finger.createPointerDown(0))
                    .addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),xCenter,yEndPoint))
                    .addAction(finger.createPointerUp(0));

            appiumDriver.perform(Arrays.asList(swipe));






        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
