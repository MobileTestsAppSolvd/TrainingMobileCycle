package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.MenuCatalogBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuCatalogBase.class)
public class MenuCatalog extends MenuCatalogBase {

    public MenuCatalog(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.mercadolibre:id/ui_components_action_bar_title_toolbar")
    private ExtendedWebElement barTitle;

    @ExtendedFindBy(text = "Inicio")
    private ExtendedWebElement homeIcon;

    @Override
    public String getBarTitle() {
        return barTitle.getText();
    }

    @Override
    public HomeScreenBase clickOnHome() {
        homeIcon.click();
        return initPage(getDriver(), HomeScreenBase.class);
    }


}
