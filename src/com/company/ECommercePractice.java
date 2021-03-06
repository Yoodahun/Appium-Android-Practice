package com.company;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ECommercePractice extends Base {

    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = initializeCapabilities();

        Thread.sleep(5000);

        System.out.println("1 --------------------------");
        //1. Verifying toast messages for error validations and then, fill the form details for shopping
        login(driver);
        Thread.sleep(3000);


        System.out.println("2 --------------------------");
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
        String text = null;

        for (int i=0;i<count;i++) {
            text = elements.get(i).getText();

            if (text.equals("Jordan 6 Rings")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                System.out.println("Jordan 6 Rings add");
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(1000);
        System.out.println("3 --------------------------");

        //3. Validate if the item selected in the page 2 are matching with items displayed in checkout page
        List<AndroidElement> orderPageElement = driver.findElementsById("com.androidsample.generalstore:id/productName");

        for(AndroidElement element : orderPageElement) {
            if(element.getText().equals(text)) {
                System.out.println("find!");
                System.out.println(element.getText());
            }
        }
        driver.quit();
        System.out.println("4 --------------------------");

        //4. Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for Shopping
        driver = initializeCapabilities();
        Thread.sleep(5000);
        login(driver);

        elements = driver.findElementsByXPath("//*[@text='ADD TO CART']");
        for (AndroidElement element: elements
             ) {
            element.click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        Thread.sleep(1000);
        Double priceSum = 0.0;

        List<AndroidElement> totalPrices = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
        for (AndroidElement priceElement: totalPrices
             ) {
            priceSum += Double.parseDouble(priceElement.getText().replace("$",""));
        }

        System.out.println(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().split(" ")[1]);
        System.out.println(priceSum);

        System.out.println("5 --------------------------");

        //5. Validating Mobile Gesture of App

        driver.findElementByClassName("android.widget.CheckBox").click();
        TouchAction touchAction = new TouchAction(driver);
//        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element( driver.findElementByClassName("android.widget.CheckBox")))).perform();

        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(driver.findElementById("com.androidsample.generalstore:id/termsButton")))
                                                                .withDuration(Duration.ofSeconds(2))).release().perform();

        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        System.out.println("visit Website !");

        Thread.sleep(7000);

        System.out.println("Web View --------------------------");

        Set<String> contexts = driver.getContextHandles();

        for (String context : contexts) {
            System.out.println(context);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");

        // 6. Verify if user can do operations on Web view and can navigate back to Native app if needed

//        driver = BaseWebApp.initializeCapabilities();
        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Hello World");
        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(Keys.ENTER);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));





    }

    public static void login(AndroidDriver<AndroidElement> driver) throws InterruptedException {

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        System.out.println(driver.findElementByXPath("//android.widget.Toast").getText());
        System.out.println(driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name"));

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
    }

}
