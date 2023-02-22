package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.MoreSoldScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreSoldScreenBase.class)
public class MoreSoldScreen extends MoreSoldScreenBase {
    @ExtendedFindBy(text = "1ºMÁS VENDIDO")
    private ExtendedWebElement moreSold;

    public MoreSoldScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMoreSoldScreenShown() {
        return moreSold.isElementPresent();
    }
}
