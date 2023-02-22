package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CellPhoneSalesBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CellPhoneSalesBase.class)
public class CellPhoneSalesScreen extends CellPhoneSalesBase {
    @FindBy(id = "com.mercadolibre:id/landing_web_view")
    private ExtendedWebElement cellPhoneLandingWeb;

    public CellPhoneSalesScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCellPhoneScreenOpened() {
        return cellPhoneLandingWeb.isElementPresent();
    }
}
