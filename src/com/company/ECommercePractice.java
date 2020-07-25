package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

public class ECommercePractice extends Base {

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //1. Fill the form details for shopping
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
        Thread.sleep(3000);

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();


    }

}
