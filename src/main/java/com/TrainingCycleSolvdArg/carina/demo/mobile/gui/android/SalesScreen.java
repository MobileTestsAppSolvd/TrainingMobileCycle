package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SalesScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SalesScreenBase.class)
public class SalesScreen extends SalesScreenBase {
    @FindBy(id = "com.mercadolibre:id/landing_swipe_refresh_layout")
    private ExtendedWebElement landingLayout;

    public SalesScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSalesScreenOpened() {
        return landingLayout.isElementPresent();
    }
}
