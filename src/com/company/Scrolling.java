package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

public class Scrolling extends Base {
    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));"
        );


    }
}
