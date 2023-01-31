package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.HomeScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.SalesScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestMercadoLibre implements IAbstractTest {

    HomeScreen homeScreen = null;

    @BeforeTest
    @TestLabel(name = "BeforeTest", value = {"mobile", "practice"})
    public void startCatalogScreen() {
        homeScreen = new HomeScreen(getDriver());
        if (homeScreen.backArrowPresent()) {
            homeScreen.clickOnBackArrowIcon();
        } else {
            MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
            menu.clickOnHome();
        }

    }

    @Test
    @TestLabel(name = "TestingApk", value = {"mobile", "practice"})
    public void testClickOnMenuIcon() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        Assert.assertTrue(homeScreen.isPageOpened(), "The page was not opened");

        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        String miCuentatext = menu.getBarTitle();

        Assert.assertEquals(miCuentatext, "Buscar en Mercado Libre", "The text was not found");
    }


    @Test
    @TestLabel(name = "TC12-testSuperButton", value = {"Mobile", "TrainingCycle"})
    public void testSuperButton() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        SuperMarketBase superScreen = homeScreen.clickOnSuper();
        Assert.assertTrue(superScreen.getSuperCard(), "The text doesn't match");

        homeScreen.clickArrowBackButton();
    }

    @Test
    @TestLabel(name = "TC02-testAddProductToCart", value = {"Mobile", "TrainingCycle"})
    public void testAddProductToCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        AddedProductScreenBase cartScreen = productScreen.clickOnAddToCart();

        Assert.assertTrue(cartScreen.getAddedProductCard(), "The product was not added to cart");
    }

    @Test
    @TestLabel(name = "TC03-testEliminateProductFromCart", value = {"Mobile", "TrainingCycle"})
    public void testEliminateProductFromCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        CartScreenBase cart = homeScreen.clickOnCartIcon();
        cart.clickOnEleminate();
        homeScreen.clickOnCartIcon();

        Assert.assertTrue(cart.getEmptyCard(), "The product was not deleted from the cart");
    }

    @Test
    @TestLabel(name = "TC04-testShowPaymentOptionsScreen", value = {"Mobile", "TrainingCycle"})
    public void testShowPaymentOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        PaymentOptionsScreenBase paymentOptions = product.clickOnViewPaymentOptionsBtn();

        Assert.assertTrue(paymentOptions.isPaymentOptionScreenShown(), "Payment Options did not open");
    }

    @Test
    @TestLabel(name = "TC05-testShippingOptionsScreen", value = {"Mobile", "TrainingCycle"})
    public void testShippingOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingOptions = product.clickOnViewShippingOptionsBtn();
        Assert.assertTrue(shippingOptions.isShippingOptionsShown(), "Shipping Options is not displayed");
    }

    @Test
    @TestLabel(name = "TC06-testKnowMoreScreenOnAProduct", value = {"Mobile", "TrainingCycle"})
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
    @Test
    @TestLabel(name = "TC09-testSalesScreen", value = {"Mobile", "TrainingCycle"})
    public void testSalesScreen(){
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.getSalesIconClick();
        SalesScreenBase salesScreen = new SalesScreen(getDriver());
        Assert.assertTrue(salesScreen.isSalesScreenOpened(),"The sales Screen is not opened");
    }
}

