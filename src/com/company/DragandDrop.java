package com.company;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragandDrop extends Base{
    public static void main(String[] args) throws InterruptedException {

            AndroidDriver<AndroidElement> driver = initializeCapabilities();
            driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
            Thread.sleep(5000);

            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
            driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(ElementOption.element(
                    driver.findElementsByClassName("android.view.View").get(0)
                    )
            ).moveTo(ElementOption.element(
                    driver.findElementsByClassName("android.view.View").get(1)
            )).release().perform();


    }
}
