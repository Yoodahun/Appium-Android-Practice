package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;

public class WebApp extends BaseWebApp {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();

        driver.get("https://m.cricbuzz.com");

        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByLinkText("Home").click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,480)");

        System.out.println(driver.findElementByXPath("//*[@id=\"top\"]/div/div[8]/h4").getAttribute("class")
                .contains("header"));

        System.out.println(driver.getCurrentUrl());

        driver.quit();



    }
}
