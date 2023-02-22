package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.FashionScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FashionScreenBase.class)
public class FashionScreen extends FashionScreenBase {
    @FindBy(id = "com.mercadolibre:id/landing_web_view")
    private ExtendedWebElement landingWebView;

    public FashionScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFashionScreenOpened() {
        return landingWebView.isElementPresent();
    }
}
