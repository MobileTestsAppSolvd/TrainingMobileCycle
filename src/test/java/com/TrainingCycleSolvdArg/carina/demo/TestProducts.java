package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTests;

public class TestProducts extends BaseTests implements IAbstractTest {

    @Test(description = "[TC04]-testShowPaymentOptionsScreen")
    public void testShowPaymentOptionsScreen() {
        TestcaseID = "121";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        PaymentOptionsScreenBase paymentOptions = product.clickOnViewPaymentOptionsBtn();

        Assert.assertTrue(paymentOptions.isPaymentOptionScreenShown(), "Payment Options did not open");
    }

    @Test(description = "[TC05]-testShippingOptionsScreen")
    public void testShippingOptionsScreen() {
        TestcaseID = "122";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingOptions = product.clickOnViewShippingOptionsBtn();
        Assert.assertTrue(shippingOptions.isShippingOptionsShown(), "Shipping Options is not displayed");
    }

    @Test(description = "[TC06]-testKnowMoreScreenOnAProduct")
    public void testKnowMoreScreenOnAProduct() {
        TestcaseID = "123";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        if (productScreen.isKnowMoreButtonNOTPresent() && productScreen.isBuyNowButtonPresent()) {
            productScreen.KnowMoreButtonError("This Product has no KnowMoreButton");
        } else if (productScreen.isKnowMoreButtonNOTPresent()) {
            KnowMoreScreenBase refundScreen = productScreen.clickOnKnowMoreButton();
            Assert.assertTrue(refundScreen.isRefundScreenOpened(), "The refund Screen was not opened");
        }
    }

    @Test(description = "[TC07]-testBuyNowBtn")
    public void testBuyNowBtn() {
        TestcaseID = "124";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        product.clickOnBuyNow();

    }
}
