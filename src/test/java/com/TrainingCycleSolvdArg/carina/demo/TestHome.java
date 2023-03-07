package com.TrainingCycleSolvdArg.carina.demo;

import Base.BaseTests;
import binding_TestRail.TestRailCaseId;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener.TestRailListener;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.recorder.RecordingPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Listeners(TestRailListener.class)
public class TestHome extends BaseTests {


    @TestRailCaseId(id = "7")
    @Test(description = "[TC09]-testSalesScreen")
    public void testSalesScreen() throws Exception {

        RecordingPage recordingPage = new RecordingPage(getDriver());

        recordingPage.startRecordingScreen();

        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SalesScreenBase salesScreen = homeScreen.clickOnSales();
        Assert.assertTrue(salesScreen.isSalesScreenOpened(), "The sales Screen is not opened");


        String video = recordingPage.stopRecordingScreen();

        //Let's save the recorded video in a specific place
        byte[] decodedVideo = Base64.getMimeDecoder().decode(video);
        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);
            Path testVideoFileLocation = Paths.get(testVideoDir.toString()
                    , String.format("%s-%d.%s", "test"
                            , System.currentTimeMillis(), "mp4"));
            Files.write(testVideoFileLocation, decodedVideo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TestRailCaseId(id = "8")
    @Test(description = "[TC12]-testSuperBtn")
    public void testSuperBtn() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SuperMarketBase superScreen = homeScreen.clickOnSuper();

        Assert.assertTrue(superScreen.isSuperCardPresent(), "The text doesn't match");
    }

    @TestRailCaseId(id = "9")
    @Test(description = "[TC11]-testCelPhoneScreen")
    public void testCelPhoneScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        CellPhoneSalesBase cellScreen = homeScreen.clickOnCellPhoneSales();

        Assert.assertTrue(cellScreen.isCellPhoneScreenOpened(), "The cellphone screen was not opened");
    }

    @TestRailCaseId(id = "10")
    @Test(description = "[TC12]-testFashionScreen")
    public void testFashionScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        FashionScreenBase fashionScreen = homeScreen.clickOnFashionSales();

        Assert.assertTrue(fashionScreen.isFashionScreenOpened(), "The cellphone screen was not opened");
    }

    @TestRailCaseId(id = "11")
    @Test(description = "[TC13]-testVideosScreen")
    public void testVideosScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        VideosScreenBase videoScreen = homeScreen.tapOnVideoBtn();

        Assert.assertTrue(videoScreen.isVideosScreenOpened(), "The video screen was not opened");
    }

    @TestRailCaseId(id = "12")
    @Test(description = "[TC14] - testVehiclesScreen")
    public void testVehiclesScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.swipeLeftFashionBtn();
        VehiclesScreenBase vehicleScreen = homeScreen.clickOnVehiclesBtn();

        Assert.assertTrue(vehicleScreen.isVehiclesScreenShown(), "Vehicles screen is not shown.");
    }

    @TestRailCaseId(id = "13")
    @Test(description = "TC15-testMoreSoldScreen")
    public void testMoreSoldScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        homeScreen.swipeLeftFashionBtn();
        MoreSoldScreenBase moreSoldScreen = homeScreen.clickOnMoreSoldBtn();

        Assert.assertTrue(moreSoldScreen.isMoreSoldScreenShown(), "More sold screen is not open");
    }

    @TestRailCaseId(id = "19")
    @Test(description = "smokeMenuTest", priority = 0)
    public void smokeMenuTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        MenuCatalogBase menu = homeScreen.clickOnMenuIcon();

        Assert.assertTrue(menu.areMainElementsPresent(), "Menu elements are not present");
    }

    @TestRailCaseId(id = "20")
    @Test(description = "SmokeHomeTest", priority = 0)
    public void smokeHomeTest() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);

        Assert.assertTrue(homeScreen.areMainElementsPresent(), "The elements are not present.");
    }
}