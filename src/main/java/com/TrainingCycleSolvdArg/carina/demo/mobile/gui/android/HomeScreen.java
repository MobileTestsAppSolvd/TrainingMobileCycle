package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.MenuCatalogBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SuperMercadoBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menú\"]")
    private ExtendedWebElement menuIcon;

    //@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mercadolibre:id/im_button_row_universal_item']")
    @FindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.ImageView")
    private ExtendedWebElement superIcon;

    @ExtendedFindBy(accessibilityId = "Atrás")
    private ExtendedWebElement backArrow;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }


    @Override
    public MenuCatalogBase clickOnMenuIcon() {
        menuIcon.click();
        return initPage(getDriver(), MenuCatalogBase.class);
    }

    @Override
    public SuperMercadoBase clickOnSuper() {
        superIcon.click();
        return initPage(getDriver(), SuperMercadoBase.class);
    }

    @Override
    public void clickArrowBackButton() {
        backArrow.click();
    }
}
