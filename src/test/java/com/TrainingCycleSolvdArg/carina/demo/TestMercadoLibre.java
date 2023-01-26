package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.HomeScreen;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.SearchPanelBar;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMercadoLibre implements IAbstractTest {

    HomeScreen homeScreen = null;

    @BeforeTest
    @TestLabel(name = "BeforeTest", value = {"mobile", "practice"})
    public void startCatalogScreen() {
        homeScreen = new HomeScreen(getDriver());
        //homeScreen.clickArrowBackButton();
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        menu.clickOnHome();

    }

    @Test
    @TestLabel(name = "TestingApk", value = {"mobile", "practice"})
    public void testClickOnMenuIcon() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        String miCuentatext = menu.getBarTitle();

        Assert.assertEquals(miCuentatext, "Buscar en Mercado Libre", "The text was not found");
    }

    @Test
    @TestLabel(name = "#12-testSuperButton", value = {"Mobile", "TrainingCycle"})
    public void testSuperButton() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        SuperMarketBase superPage = homeScreen.clickOnSuper();
        String texto = superPage.getSuperText();
        homeScreen.clickArrowBackButton();

        Assert.assertEquals(texto, "Supermercado", "The text doesn't match");
    }

    @Test
    @TestLabel(name = "#2-testAddProductToCart", value = {"Mobile", "TrainingCycle"})
    public void testAddProductToCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.TapOnSearchBar();
        SearchPanelBarBase panelSearch = new SearchPanelBar(getDriver());
        panelSearch.typeTheProduct("cartera");
        ProductScreenBase productScreen = panelSearch.clickOnProductsName();
        productScreen.clickOnTheFirstProduct();
        productScreen.swipeUp();
        AddedProductScreenBase carritoScreen = productScreen.clickOnAgregarAlCarrito();
        String message = carritoScreen.getAddedProductMessage();
        homeScreen.clickArrowBackButton();
        homeScreen.swipeDown();
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        menu.clickOnHome();

        Assert.assertEquals(message, "Agregaste a tu cart", "The product was not added to cart");
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

