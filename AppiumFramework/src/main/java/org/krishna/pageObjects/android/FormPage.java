package org.krishna.pageObjects.android;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.krishna.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropdownField;
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioButton;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    public void setActivity(){
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Male"))
            maleRadioButton.click();
        else
            femaleRadioButton.click();
    }

    public ProductCataloguePage clickBtnLetsShop(){
        btnLetsShop.click();
        return new ProductCataloguePage(driver);
    }

    public void setCountryDropdownField(String countryName){
        countryDropdownField.click();
        scrollToText(driver,countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

}
