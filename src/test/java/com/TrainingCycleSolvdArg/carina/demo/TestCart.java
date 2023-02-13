package com.TrainingCycleSolvdArg.carina.demo;

import binding_TestRail.TestRailManager;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTests;

public class TestCart extends BaseTests implements IAbstractTest {

    @Test(description = "[TC02]-testAddProductToCart")
    public void testAddProductToCart() {
        TestcaseID = "119";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        AddedProductScreenBase cartScreen = productScreen.clickOnAddToCart();

        Assert.assertTrue(cartScreen.isAddedProductCard(), "The product was not added to cart");
    }

    @Test(description = "[TC03]-testEliminateProductFromCart")
    public void testEliminateProductFromCart() {
        TestcaseID = "120";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        CartScreenBase cart = homeScreen.clickOnCartIcon();
        cart.clickOnEleminate();
        homeScreen.clickOnCartIcon();

        Assert.assertTrue(cart.isEmptyCard(), "The product was not deleted from the cart");
    }
}
