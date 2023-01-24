package com.TrainingCycleSolvdArg.carina.demo;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.SearchPanelBar;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMercadoLibre implements IAbstractTest {
    @Test
    @MethodOwner(owner = "BarreraGerman")
    @TestLabel(name = "TestingApk", value = {"mobile", "practice"})
    public void testClickOnMenuIcon() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        String miCuentatext = menu.getCuentaText();
        Assert.assertEquals(miCuentatext, "Buscar en Mercado Libre", "The text was not found");
    }

    @Test
    @MethodOwner(owner = "BarreraGerman")
    @TestLabel(name = "#12-testSuperButton", value = {"Mobile", "TrainingCycle"})
    public void testSuperButton() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SuperMercadoBase superPage = homeScreen.clickOnSuper();
        String texto = superPage.getSuperText();
        homeScreen.clickArrowBackButton();
        Assert.assertEquals(texto, "Supermercado", "The text doesn't match");

    }

    @Test
    @MethodOwner(owner = "BarreraGerman")
    @TestLabel(name = "#1-testAddAndRemoveAProductFromCart", value = {"Mobile", "TrainingCycle"})
    public void testAddAndRemoveAProductFromCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.TapOnSearchBar();
        SearchPanelBarBase panelSearch = new SearchPanelBar(getDriver());
        panelSearch.typeTheProduct("cartera");
        ProductScreenBase productScreen = panelSearch.clickOnProductsName();
        productScreen.clickOnTheFirstProduct();
        productScreen.swipeUp();
        productScreen.clickOnAgregarAlCarrito();
        homeScreen.clickArrowBackButton();
        homeScreen.swipeDown();
        CarritoScreenBase carrito = homeScreen.clickOnCarritoIcon();
        carrito.clickOnEleminar();
        String items = carrito.getCarritoItems();
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        menu.clickOnInicio();

        Assert.assertEquals(items, "Carrito (0)", "The product was not eliminated");
    }

    @Test
    @MethodOwner(owner = "BarreraGerman")
    @TestLabel(name = "#2-testAddProductToCart", value = {"Mobile", "TrainingCycle"})
    public void testAddProductToCart() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        homeScreen.TapOnSearchBar();
        SearchPanelBarBase panelSearch = new SearchPanelBar(getDriver());
        panelSearch.typeTheProduct("cartera");
        ProductScreenBase productScreen = panelSearch.clickOnProductsName();
        productScreen.clickOnTheFirstProduct();
        productScreen.swipeUp();
        ProductoAgregadoScreenBase carritoScreen = productScreen.clickOnAgregarAlCarrito();
        String message = carritoScreen.getAddedProductMessage();
        homeScreen.clickArrowBackButton();
        homeScreen.swipeDown();
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        menu.clickOnInicio();

        Assert.assertEquals(message, "Agregaste a tu carrito", "The product was not added to cart");

    }

}