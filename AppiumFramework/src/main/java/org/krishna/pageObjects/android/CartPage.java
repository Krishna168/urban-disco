package org.krishna.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.krishna.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement btnVisitToWebsite;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> lstEleProductPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalPurchaseAmount;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBoxSendMeEmail;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndConditions;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CLOSE']")
    private WebElement btnCloseTermsAndConditionsPopup;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement titleTermsAndConditionsPopup;

    public WebElement getWebEleBtnVistToWebsite() {
        return btnVisitToWebsite;
    }

    public void clickBtnVistToWebsite(){
        btnVisitToWebsite.click();
    }

    public void clickBtnVisitToWebsite() {
        btnVisitToWebsite.click();
    }

    public List<WebElement> getLstEleProductPrice(){
        return lstEleProductPrice;
    }

    public double getSumOfProductPricesOnCart(){
        List<WebElement> lstEleProductPrice = getLstEleProductPrice();
        double sumOfProducts = 0;
        for (WebElement e : lstEleProductPrice) {
            sumOfProducts = sumOfProducts + getFormattedAmount(e.getText());
        }
        return sumOfProducts;
    }

    public Double getTotalPurchaseAmount(){
        return getFormattedAmount(totalPurchaseAmount.getText());
    }

    public void enableCheckBoxSendMeMails(){
        checkBoxSendMeEmail.click();
    }

    public void longPressTermsAndConditions(){
        longPressAction(termsAndConditions);
        expWaitForEleVisibility(driver,btnCloseTermsAndConditionsPopup);
    }

    public String getTermsAndConditionsPopupTitle(){
        return titleTermsAndConditionsPopup.getText();
    }

    public void clickBtnCloseTermsAndConditionsPopup(){
        btnCloseTermsAndConditionsPopup.click();
    }


}
