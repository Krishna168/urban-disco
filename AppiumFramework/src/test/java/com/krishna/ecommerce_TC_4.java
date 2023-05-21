package com.krishna;

import com.krishna.testUtils.AndroidBaseTest;
import org.krishna.pageObjects.android.CartPage;
import org.krishna.pageObjects.android.ProductCataloguePage;
import org.krishna.utils.AppiumUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ecommerce_TC_4 extends AndroidBaseTest {

    @BeforeMethod
    public void preSetup(){
        formPage.setActivity();
    }

    @Test(dataProvider = "getData")
    public void handleHybridApp(HashMap<String, String> input) throws InterruptedException {
        formPage.setCountryDropdownField(input.get("countryName"));
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        ProductCataloguePage productCataloguePage = formPage.clickBtnLetsShop();
        productCataloguePage.addItemToCartByIndex(0);
        productCataloguePage.addItemToCartByIndex(0);
        CartPage cartPage = productCataloguePage.clickBtnCart();
//        waitMethods = new WaitMethods(driver);
//        waitMethods.expWaitForEleVisibility(cartPage.getWebEleBtnVisitToWebsite());
        cartPage.expWaitForEleVisibility(driver,cartPage.getWebEleBtnVistToWebsite());
        double sumOfProductPricesOnCart = cartPage.getSumOfProductPricesOnCart();
        double totalPurchaseAmount = cartPage.getTotalPurchaseAmount();
        Assert.assertEquals(sumOfProductPricesOnCart, totalPurchaseAmount,
                "Total Purchase Amount displayed is not equals to sum of products total on Cart Page.");
        cartPage.enableCheckBoxSendMeMails();
        cartPage.longPressTermsAndConditions();
        String alertTitle = cartPage.getTermsAndConditionsPopupTitle();
        Assert.assertEquals(alertTitle, "Terms Of Conditions", "Terms and Conditions popup Title is not as Expected.");
        cartPage.clickBtnCloseTermsAndConditionsPopup();
        cartPage.clickBtnVistToWebsite();
        Thread.sleep(5000);
    }

    @DataProvider
    public Object[][] getData(){
        AppiumUtils appiumUtils = new AppiumUtils();
        List<HashMap<String, String>> jsonData = appiumUtils.getJsonData("eCommerce.json");
        return new Object[][]{{jsonData.get(0)},{jsonData.get(1)},{jsonData.get(2)}};
    }

//    public void openfile() throws IOException {
//        File htmlFile = new File(url);
//        Desktop.getDesktop().browse(htmlFile.toURI());
//    }
}
