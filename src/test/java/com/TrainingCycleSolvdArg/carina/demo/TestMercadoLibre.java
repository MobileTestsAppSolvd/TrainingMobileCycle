package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.HomeScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.ProductScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.SearchPanelBar;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestMercadoLibre implements IAbstractTest {

    @Test
    @TestLabel(name = "#12-testSuperButton", value = {"Mobile", "TrainingCycle"})
    public void testSuperButton() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        SuperMarketBase superScreen = homeScreen.clickOnSuper();
        Assert.assertTrue(superScreen.getSuperCard(), "The text doesn't match");

        homeScreen.clickArrowBackButton();
    }

    @Test
    @TestLabel(name = "#2-testAddProductToCart", value = {"Mobile", "TrainingCycle"})
    public void testAddProductToCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        List<WebElement> visitedProducts = homeScreen.getLastVisitedProductAndClickOnIt();
        ProductScreenBase productScreen = new ProductScreen(getDriver());
        productScreen.swipeUp();
        AddedProductScreenBase cartScreen = productScreen.clickOnAddToCart();

        Assert.assertTrue(cartScreen.getAddedProductCard(), "The product was not added to cart");
    }

    @Test
    @TestLabel(name = "#3-testEliminateProductFromCart", value = {"Mobile", "TrainingCycle"})
    public void testEliminateProductFromCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        CartScreenBase cart = homeScreen.clickOnCartIcon();
        cart.clickOnEleminate();
        homeScreen.clickOnCartIcon();

        Assert.assertTrue(cart.getEmptyCard(), "The product was not deleted from the cart");
    }
}

