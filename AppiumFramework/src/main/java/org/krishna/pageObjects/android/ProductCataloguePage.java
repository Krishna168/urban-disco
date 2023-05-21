package org.krishna.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.krishna.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AndroidActions {

    AndroidDriver driver;

    public ProductCataloguePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement btnCart;


    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();
    }

    public CartPage clickBtnCart() {
        btnCart.click();
        return new CartPage(driver);
    }


}
