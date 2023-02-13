package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.*;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMercadoLibre implements IAbstractTest {

    @Test(description = "TestingApk")
    public void testClickOnMenuIcon() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        Assert.assertTrue(homeScreen.isPageOpened(), "The page was not opened");

        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        String miCuentatext = menu.getBarTitle();

        Assert.assertEquals(miCuentatext, "Buscar en Mercado Libre", "The text was not found");
    }


    @Test(description = "[TC12]-testSuperButton")
    public void testSuperButton() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        SuperMarketBase superScreen = homeScreen.clickOnSuper();
        Assert.assertTrue(superScreen.isSuperCardPresent(), "The text doesn't match");

        homeScreen.clickArrowBackButton();
    }

    @Test(description = "[TC02]-testAddProductToCart")
    public void testAddProductToCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        AddedProductScreenBase cartScreen = productScreen.clickOnAddToCart();

        Assert.assertTrue(cartScreen.isAddedProductCard(), "The product was not added to cart");
    }

    @Test(description = "[TC03]-testEliminateProductFromCart")
    public void testEliminateProductFromCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        CartScreenBase cart = homeScreen.clickOnCartIcon();
        cart.clickOnEleminate();
        homeScreen.clickOnCartIcon();

        Assert.assertTrue(cart.isEmptyCard(), "The product was not deleted from the cart");
    }

    @Test(description = "[TC04]-testShowPaymentOptionsScreen")
    public void testShowPaymentOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        PaymentOptionsScreenBase paymentOptions = product.clickOnViewPaymentOptionsBtn();

        Assert.assertTrue(paymentOptions.isPaymentOptionScreenShown(), "Payment Options did not open");
    }

    @Test(description = "[TC05]-testShippingOptionsScreen")
    public void testShippingOptionsScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingOptions = product.clickOnViewShippingOptionsBtn();
        Assert.assertTrue(shippingOptions.isShippingOptionsShown(), "Shipping Options is not displayed");
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

    @Test(description = "[TC07]-testBuyNowBtn")
    public void testBuyNowBtn() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        ProductScreenBase product = homeScreen.clickOnLastSeenProduct();
        ShippingOptionsScreenBase shippingScreen = product.clickOnBuyNow();

        Assert.assertTrue(shippingScreen.selectAShippingOption().contains("Selecciona un método de entrega"), "Buy Now button is not working");
    }

    @Test(description = "[TC09]-testSalesScreen")
    public void testSalesScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.getSalesIconClick();
        SalesScreenBase salesScreen = new SalesScreen(getDriver());
        Assert.assertTrue(salesScreen.isSalesScreenOpened(), "The sales Screen is not opened");
    }

    @Test(description = "[TC11]-testCelPhoneScreen")
    public void testCelPhoneScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.clickOnCellPhoneSales();
        CellPhoneSalesBase cellScreen = new CellPhoneSalesScreen(getDriver());
        Assert.assertTrue(cellScreen.isCellPhoneScreenOpened(), "The cellphone screen was not opened");
    }

    @Test(description = "[TC13]-testVideosScreen")
    public void testVideosScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        VideosScreenBase videoScreen = homeScreen.tapOnVideoBtn();
        Assert.assertTrue(videoScreen.isVideosScreenOpened(), "The video screen was not opened");
    }

    @Test(description = "[TC12]-testFashionScreen")
    public void testFashionScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.clickOnFashionSales();
        FashionScreenBase fashionScreen = new FashionScreen(getDriver());
        Assert.assertTrue(fashionScreen.isFashionScreenOpened(), "The cellphone screen was not opened");
    }


    @Test(description = "[TC14] - testVehiclesScreen")
    public void testVehiclesScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        VehiclesScreenBase vehicles = homeScreen.clickOnVehiclesBtn();

        homeScreen.swipeLeftFashionBtn();
        VehiclesScreenBase vehicleScreen = homeScreen.clickOnVehiclesBtn();

        Assert.assertTrue(vehicleScreen.isVehiclesScreenShown(), "Vehicles screen is not shown.");
    }

    @Test(description = "TC15-testMoreSoldScreen")
    public void testMoreSoldScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.swipeLeftFashionBtn();
        MoreSoldScreenBase moreSoldScreen = homeScreen.clickOnMoreSoldBtn();

        Assert.assertTrue(moreSoldScreen.isMoreSoldScreenShown(),"More sold screen is not open");
    }


}

