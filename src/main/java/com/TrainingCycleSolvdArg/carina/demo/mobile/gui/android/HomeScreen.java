package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.MenuCatalogBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menú\"]")
    private ExtendedWebElement menuIcon;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }



    @Override
    public MenuCatalogBase clickOnMenuIcon() {
        menuIcon.click();
        return initPage(getDriver(), MenuCatalogBase.class);
    }
}
