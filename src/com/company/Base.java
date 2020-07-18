package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class Base {

    public static AndroidDriver<AndroidElement> initializeCapabilities() {
        // write your code here

        File file = new File("/Users/yoodahun/Documents/Github/Java/Appium -Mobile Automation Testing from Scratch/Library/ApiDemos-debug.apk");

        AndroidDriver<AndroidElement> driver = null;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PracticeEmul");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP,
                file.getAbsolutePath());

        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (Exception e) {

        }

        return driver;

    }
}
