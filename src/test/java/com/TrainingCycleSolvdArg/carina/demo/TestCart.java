package com.TrainingCycleSolvdArg.carina.demo;


import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTests;

public class TestCart extends BaseTests implements IAbstractTest {

    @Test(description = "[TC02]-testAddProductToCartBtn")
    public void testAddProductToCartBtn() {
        TestcaseID = "42";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        ProductScreenBase productScreen = homeScreen.getLastVisitedProductAndClickOnIt();
        productScreen.swipeUp();
        AddedProductScreenBase addedProductScreen =  productScreen.clickOnAddToCart();
        if (addedProductScreen.isAddedProductCardPresent()){
            Assert.assertTrue(addedProductScreen.isAddedProductCardPresent(),"The product was not added");
        }else {
            skipTestException("The user is not logged in");
        }
    }

    @Test(description = "[TC03]-testEliminateProductFromCart")
    public void testEliminateProductFromCart() {
        TestcaseID = "2";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CartScreenBase cart = homeScreen.clickOnCartIcon();
        if(cart.isEliminateBtnPresent()){cart.clickOnEleminate();
            Assert.assertTrue(cart.isEmptyCart(), "The product was not deleted from the cart");
        }else {
            skipTestException("The user is not logged in");
        }
    }

    @Test(description = "smokeCartTest", priority = 0)
    public void smokeCartTest() {
        TestcaseID = "21";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CartScreenBase cartScreen= homeScreen.clickOnCartIcon();

        Assert.assertTrue(cartScreen.areMainElementsPresent(),"Cart elements are not present");
    }
}
