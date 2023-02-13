package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProducts implements IAbstractTest {

    @Test(description = "[TC04]-testShowPaymentOptionsScreen")
    public void testShowPaymentOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        PaymentOptionsScreenBase paymentOptions = product.clickOnViewPaymentOptionsBtn();

        Assert.assertTrue(paymentOptions.isPaymentOptionScreenShown(), "Payment Options did not open");
    }

    @Test(description = "[TC06]-testKnowMoreScreenOnAProduct")
    public void testKnowMoreScreenOnAProduct() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        if (productScreen.isKnowMoreButtonPresent()) {
            KnowMoreScreenBase refundScreen = productScreen.clickOnKnowMoreButton();
            Assert.assertTrue(refundScreen.isRefundScreenOpened(), "The refund Screen was not opened");
        } else if (productScreen.isBuyNowButtonPresent() && !productScreen.isKnowMoreButtonPresent()) {
            Assert.assertFalse(productScreen.isKnowMoreButtonPresent(), "The refund Screen was opened");
        }
    }

    @Test(description = "[TC05]-testShippingOptionsScreen")
    public void testShippingOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingOptions = product.clickOnViewShippingOptionsBtn();
        Assert.assertTrue(shippingOptions.isShippingOptionsShown(), "Shipping Options is not displayed");
    }

    @Test(description = "[TC07]-testBuyNowBtn")
    public void testBuyNowBtn() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingScreen = product.clickOnBuyNow();

        Assert.assertTrue(shippingScreen.selectAShippingOption().contains("Selecciona un método de entrega"), "Buy Now button is not working");
    }
}
