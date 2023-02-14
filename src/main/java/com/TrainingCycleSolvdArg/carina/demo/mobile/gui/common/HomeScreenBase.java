package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class HomeScreenBase extends AbstractPage implements IMobileUtils {

    public HomeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductScreenBase clickOnLastSeenProduct();

    public abstract MenuCatalogBase clickOnMenuIcon();

    public abstract SuperMarketBase clickOnSuper();

    public abstract void clickArrowBackButton();

    public abstract void TapOnSearchBar();

    public abstract void swipeDown();

    public abstract VideosScreenBase tapOnVideoBtn();

    public abstract CartScreenBase clickOnCartIcon();

    public abstract boolean isPageOpened();

    public abstract List<WebElement> getLastVisitedProductAndClickOnIt();

    public abstract CellPhoneSalesBase clickOnCellPhoneSales();

    public abstract List<WebElement> clickOnFashionSales();

    public abstract List<WebElement> getSalesIconClick();

    public abstract ProductScreenBase clickOnBackArrowIcon();

    public abstract boolean isBackArrowPresent();

    public abstract List<ExtendedWebElement> findExtendedWebElements(By by);

    public abstract VehiclesScreenBase clickOnVehiclesBtn();

    public abstract void swipeLeftFashionBtn();

    public abstract MoreSoldScreenBase clickOnMoreSoldBtn();
}
