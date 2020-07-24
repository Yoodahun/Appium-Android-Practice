package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebApp extends BaseWebApp {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();

        driver.get("https://m.cricbuzz.com");

        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByLinkText("Home").click();
        System.out.println(driver.getCurrentUrl());

        driver.quit();



    }
}
