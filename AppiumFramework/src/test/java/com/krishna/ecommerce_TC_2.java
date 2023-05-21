package com.krishna;

import com.krishna.testUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ecommerce_TC_2 extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup() {
        //Setting the screen to HomePage.
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }

    @Test(priority = 1)
    public void verifyToastMessage() {

        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		String toastMsg = driver.findElement(Bycls.xpath("//android.widget.Toast")).getAttribute("name");
        String toastMsg = driver.findElement(By.xpath("//android.widget.Toast")).getText();
        System.out.println(toastMsg);
        Assert.assertEquals(toastMsg, "Please enter your name", "Toast Message for Name Field is not as Expected.");
    }

    @Test(priority = 2)
    public void fillFormPositiveFlow() {

        driver.findElement(By.id("android:id/text1")).click();
//		scrollIntoByAppiumToTextVisible("India");
        driver.findElement(
                AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Krishna");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast")).size() < 1);
    }


}
