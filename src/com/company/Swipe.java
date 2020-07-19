package com.company;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Swipe extends Base {
    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();

        TouchAction touchAction = new TouchAction(driver);
        //long press on element 2 sec?
        touchAction.longPress(
                LongPressOptions.longPressOptions()
                                .withElement(ElementOption.element(driver.findElementByXPath("//*[@content-desc='15']")))
                                .withDuration(Duration.ofSeconds(2))
                ).moveTo(ElementOption.element(driver.findElementByXPath("//*[@content-desc='45']")))
                .release().perform();

        //move to another element and release






    }
}
