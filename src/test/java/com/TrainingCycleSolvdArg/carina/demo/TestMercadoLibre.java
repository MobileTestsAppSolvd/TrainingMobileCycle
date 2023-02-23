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
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();
        String miCuentatext = menu.getBarTitle();

        Assert.assertEquals(miCuentatext, "Buscar en Mercado Libre", "The text was not found");
    }
}

