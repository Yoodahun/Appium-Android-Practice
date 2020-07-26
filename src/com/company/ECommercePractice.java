package com.company;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ECommercePractice extends Base {

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //1. Verifying toast messages for error validations and then, fill the form details for shopping
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        System.out.println(driver.findElementByXPath("//android.widget.Toast").getText());
        System.out.println(driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name"));

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
        Thread.sleep(3000);

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        //2. Shop the items in the app by scrolling to specific Product and add to cart
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(" +
                            "new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")" +
                        ").scrollIntoView(" +
                            "new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0)" +
                        ");"
        );

        List<AndroidElement> elements = driver.findElementsById("com.androidsample.generalstore:id/productName");
        int count = elements.size();

        for (int i=0;i<count;i++) {
            String text = elements.get(i).getText();

            if (text.equals("Jordan 6 Rings")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();


    }

}
