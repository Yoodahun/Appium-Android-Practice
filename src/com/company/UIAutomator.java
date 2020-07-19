package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomator extends Base {

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
//        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

        System.out.println(
            driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()
        );
    }


}
