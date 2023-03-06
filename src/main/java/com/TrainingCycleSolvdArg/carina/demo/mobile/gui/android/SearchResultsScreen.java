package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SearchResultsScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultsScreenBase.class)
public class SearchResultsScreen extends SearchResultsScreenBase {

    @FindBy(id = "com.mercadolibre:id/search_appbar_action_title")
    private ExtendedWebElement filterBtn;


    public SearchResultsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFilterBtnPresent() {
        return filterBtn.isElementPresent();
    }
}
