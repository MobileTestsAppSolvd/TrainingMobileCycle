package com.TrainingCycleSolvdArg.carina.demo;

import Base.BaseTests;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHome extends BaseTests implements IAbstractTest {

    @Test(description = "[TC09]-testSalesScreen")
    public void testSalesScreen() {
        TestcaseID = "125";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SalesScreenBase salesScreen = homeScreen.clickOnSales();

        Assert.assertTrue(salesScreen.isSalesScreenOpened(), "The sales Screen is not opened");
    }

    @Test(description = "[TC12]-testSuperBtn")
    public void testSuperBtn() {
        TestcaseID = "126";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SuperMarketBase superScreen = homeScreen.clickOnSuper();

        Assert.assertTrue(superScreen.isSuperCardPresent(), "The text doesn't match");
    }

    @Test(description = "[TC11]-testCelPhoneScreen")
    public void testCelPhoneScreen() {
        TestcaseID = "127";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CellPhoneSalesBase cellScreen = homeScreen.clickOnCellPhoneSales();

        Assert.assertTrue(cellScreen.isCellPhoneScreenOpened(), "The cellphone screen was not opened");
    }

    @Test(description = "[TC12]-testFashionScreen")
    public void testFashionScreen() {
        TestcaseID = "128";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        FashionScreenBase fashionScreen = homeScreen.clickOnFashionSales();

        Assert.assertTrue(fashionScreen.isFashionScreenOpened(), "The cellphone screen was not opened");
    }

    @Test(description = "[TC13]-testVideosScreen")
    public void testVideosScreen() {
        TestcaseID = "128";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        VideosScreenBase videoScreen = homeScreen.tapOnVideoBtn();

        Assert.assertTrue(videoScreen.isVideosScreenOpened(), "The video screen was not opened");
    }

    @Test(description = "[TC14] - testVehiclesScreen")
    public void testVehiclesScreen() {
        TestcaseID = "130";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.swipeLeftFashionBtn();
        VehiclesScreenBase vehicleScreen = homeScreen.clickOnVehiclesBtn();

        Assert.assertTrue(vehicleScreen.isVehiclesScreenShown(), "Vehicles screen is not shown.");
    }

    @Test(description = "TC15-testMoreSoldScreen")
    public void testMoreSoldScreen() {
        TestcaseID = "131";
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.swipeLeftFashionBtn();
        MoreSoldScreenBase moreSoldScreen = homeScreen.clickOnMoreSoldBtn();

        Assert.assertTrue(moreSoldScreen.isMoreSoldScreenShown(), "More sold screen is not open");
    }


    @Test(description = "smokeMenuTest", priority = 0)
    public void smokeMenuTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();

        Assert.assertTrue(menu.areMainElementsPresent(), "Menu elements are not present");
    }

    @Test(description = "SmokeHomeTest", priority = 0)
    public void smokeHomeTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        Assert.assertTrue(homeScreen.areMainElementsPresent(), "The elements are not present.");
    }
}