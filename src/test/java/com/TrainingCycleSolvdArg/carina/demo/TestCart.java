package com.TrainingCycleSolvdArg.carina.demo;


import binding_TestRail.TestRailCaseId;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTests;

public class TestCart extends BaseTests implements IAbstractTest {
    @TestRailCaseId(id = "42")
    @Test(description = "[TC02]-testAddProductToCartBtn")
    public void testAddProductToCartBtn() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        ProductScreenBase productScreen = homeScreen.getLastVisitedProductAndClickOnIt();
        AddedProductScreenBase addedProductScreen =  productScreen.clickOnAddToCart();
        if (addedProductScreen.isAddedProductCardPresent()){
            Assert.assertTrue(addedProductScreen.isAddedProductCardPresent(),"The product was not added");
        }else {
            skipTestException("The user is not logged in");
        }
    }

    @TestRailCaseId(id = "2")
    @Test(description = "[TC03]-testEliminateProductFromCart")
    public void testEliminateProductFromCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CartScreenBase cart = homeScreen.clickOnCartIcon();
        if(cart.isEliminateBtnPresent()){
            cart.clickOnEliminate();
        }else {
            skipTestException("The user is not logged in");
        }
    }

    @TestRailCaseId(id = "21")
    @Test(description = "smokeCartTest", priority = 0)
    public void smokeCartTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CartScreenBase cartScreen= homeScreen.clickOnCartIcon();

        Assert.assertTrue(cartScreen.areMainElementsPresent(),"Cart elements are not present");
    }
}
