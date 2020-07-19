package com.company;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Gestures extends Base{

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        TouchAction t = new TouchAction(driver);

        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(
                driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")
        ))).perform();

        driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();

        t.longPress(LongPressOptions.longPressOptions().withElement(
                ElementOption.element(
                        driver.findElementByAndroidUIAutomator("text(\"People Names\")")
                )
        ).withDuration(Duration.ofSeconds(2))
        ).release().perform();

        System.out.println(
            driver.findElementById("android:id/title").isDisplayed()
        );


    }
}
