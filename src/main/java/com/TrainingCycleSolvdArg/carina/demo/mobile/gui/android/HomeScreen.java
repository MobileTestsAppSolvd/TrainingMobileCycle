package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
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

    @FindBy(id = "com.mercadolibre:id/ui_components_action_bar_title_toolbar")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.mercadolibre:id/vpp_action_bar_bookmark")
    private ExtendedWebElement bookMark;

    @FindBy(id = "com.mercadolibre:id/cart_icon")
    private ExtendedWebElement cartIcon;

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

    @Override
    public void TapOnSearchBar() {
        searchBar.click();
    }

    @Override
    public void swipeDown() {
    swipe(bookMark,Direction.DOWN);
    }

    @Override
    public CarritoScreenBase clickOnCarritoIcon() {
        cartIcon.click();
        return initPage(getDriver(), CarritoScreenBase.class);
    }

}
