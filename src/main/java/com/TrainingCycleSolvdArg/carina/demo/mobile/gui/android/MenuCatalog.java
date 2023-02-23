package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.HomeScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.MenuCatalogBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuCatalogBase.class)
public class MenuCatalog extends MenuCatalogBase {
    public MenuCatalog(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.mercadolibre:id/ui_components_action_bar_title_toolbar")
    private ExtendedWebElement barTitle;
    @ExtendedFindBy(text = "Inicio")
    private ExtendedWebElement homeIcon;
    @FindBy(xpath = "//*[@resource-id='com.mercadolibre:id/drawer_navigation_tag_text']")
    private ExtendedWebElement menuElements;

    @Override
    public String getBarTitle() {
        return barTitle.getText();
    }

    @Override
    public HomeScreenBase clickOnHome() {
        homeIcon.click();
        return initPage(getDriver(), HomeScreenBase.class);
    }

    @Override
    public boolean areMainElementsPresent() {
        List<ExtendedWebElement> list = findExtendedWebElements(menuElements.getBy(), 5000);
        return list.get(0).isElementPresent() && list.get(1).isElementPresent() && list.get(2).isElementPresent();
    }
}
