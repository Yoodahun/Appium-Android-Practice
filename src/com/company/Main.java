package com.company;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AndroidDriver<AndroidElement> driver = Base.initializeCapabilities();

        Thread.sleep(5000);

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementsByXPath("//android.widget.RelativeLayout").get(1).click();
        driver.findElementById("android:id/edit").sendKeys("hello");
        driver.findElementsByClassName("android.widget.Button").get(1).click();





    }
}
