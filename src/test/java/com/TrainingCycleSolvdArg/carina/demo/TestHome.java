package com.TrainingCycleSolvdArg.carina.demo;

import Base.BaseTests;
import binding_TestRail.TestRailCaseId;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener.TestRailListener;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

@Listeners(TestRailListener.class)
public class TestHome extends BaseTests {
    @TestRailCaseId(id = "7")
    @Test(description = "[TC09]-testSalesScreen")
    public void testSalesScreen() {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SalesScreenBase salesScreen = homeScreen.clickOnSales();

        Assert.assertTrue(salesScreen.isSalesScreenOpened(), "The sales Screen is not opened");
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

    //FUNCIONA CON TESRAIL COMENTADO. csv con DataProvider se usa map y data.get("Search"), se quita el dsArgs, se quita el sheet
    //@TestRailCaseId(id = "43")
    @TestRailCases(testCasesId = "19")
    @Test(description = "[TC]-testSearchbarWithCSVDataprovider", dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "dataProviderFiles/searchbarDataProvider.csv", dsUid ="TUID")
    public void testSearchbarCSV(HashMap<String, String> data){
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SearchResultsScreenBase results = homeScreen.inputSearch(data.get("Search"));
        Assert.assertTrue(results.isFilterBtnPresent());
    }

    //FUNCIONA CON TESRAIL COMENTADO.xls con DataProvider, se usa map y data.get("Search"), se quita el dsArgs
    //@TestRailCaseId(id = "44")
    @TestRailCases(testCasesId = "20")
    @Test(description = "[TC]-testSearchbarWithXLSDataprovider", dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "dataProviderFiles/dataProviderXLSFile.xlsx", sheet = "Mobile-DataProvider",dsUid = "TUID")
    public void testSearchbarXLS(HashMap<String, String> data){
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SearchResultsScreenBase results = homeScreen.inputSearch(data.get("Search"));
        Assert.assertTrue(results.isFilterBtnPresent());
    }

    //FUNCIONA CON TESRAIL COMENTADO.csv con SingleDataProvider, se agrega dsArgs = "Search"
    @Test(description = "[TC]-testSearchbarWithCSVSingleDataprovider", dataProvider = "SingleDataProvider")
    @TestRailCaseId(id = "45")
    @CsvDataSourceParameters(path = "dataProviderFiles/searchbarDataProvider.csv", dsUid ="TUID")
    public void testSearchbarCSVsingle(HashMap<String, String> data){
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SearchResultsScreenBase results = homeScreen.inputSearch(data.get("Search"));
        Assert.assertTrue(results.isFilterBtnPresent());
    }

    //FUNCIONA CON TESRAIL COMENTADO.xls con SingleDataProvider, se agrega dsArgs = "Search"
    @TestRailCaseId(id = "46")
    @Test(description = "[TC]-testSearchbarWithXLSSingleDataprovider", dataProvider = "SingleDataProvider")
    @XlsDataSourceParameters(path = "dataProviderFiles/dataProviderXLSFile.xlsx", sheet = "Mobile-DataProvider",dsUid = "TUID", dsArgs = "Search")
    public void testSearchbarXLSsingle(String data){
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        SearchResultsScreenBase results = homeScreen.inputSearch(data);
        Assert.assertTrue(results.isFilterBtnPresent());
    }

    /*CONCLUSIONES:
    CSV funciona siempre con map. puede usarse singleDataProvider(solo lleva path y dsuid) o DataProvider(solo lleva path y dsuid)
    XLS puede funcionar con singleDataProvider(con path, sheet, dsuid, dsargs y aplicando string como parametro) o con DataProvider(con path, sheet, dsuid y aplicando hashmap como parametro)

    TODO: ver como se implementa cuando descomento testrail :(
    * */
}