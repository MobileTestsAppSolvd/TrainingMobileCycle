package com.TrainingCycleSolvdArg.carina.demo;

import binding_TestRail.TestRailCaseId;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTests;

public class TestProducts extends BaseTests implements IAbstractTest {
    @TestRailCaseId(id = "3")
    @Test(description = "[TC04]-testShowPaymentOptionsScreen")
    public void testShowPaymentOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        PaymentOptionsScreenBase paymentOptions = product.clickOnViewPaymentOptionsBtn();

        Assert.assertTrue(paymentOptions.isPaymentOptionScreenShown(), "Payment Options did not open");
    }
    @TestRailCaseId(id = "4")
    @Test(description = "[TC05]-testShippingOptionsScreen")
    public void testShippingOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingOptions = product.clickOnViewShippingOptionsBtn();

        Assert.assertTrue(shippingOptions.isShippingOptionsShown(), "Shipping Options is not displayed");
    }
    @TestRailCaseId(id = "5")
    @Test(description = "[TC06]-testKnowMoreScreenOnAProduct")
    public void testKnowMoreScreenOnAProduct() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();

        if (productScreen.isKnowMoreButtonPresent()){
            KnowMoreScreenBase refundScreen = productScreen.clickOnKnowMoreButton();
            Assert.assertTrue(refundScreen.isRefundScreenOpened(), "The refund Screen was not opened");
        }else{
            skipTestException("This Product has no KnowMoreButton");
        }
    }
    @TestRailCaseId(id = "6")
    @Test(description = "[TC07]-testBuyNowBtn")
    public void testBuyNowBtn() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        product.clickOnBuyNow();
    }
    @TestRailCaseId(id = "41")
    @Test(description = "createSmokeProductTest")
    public void createSmokeProductTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();

        Assert.assertTrue(product.areMainElementsPresent(),"The product elements are not present");
    }
}
