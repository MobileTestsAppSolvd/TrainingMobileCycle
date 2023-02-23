package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.KnowMoreScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = KnowMoreScreenBase.class)
public class KnowMoreScreen extends KnowMoreScreenBase {
    @ExtendedFindBy(accessibilityId = "políticas de devolución.")
    private ExtendedWebElement refundScreen;

    public KnowMoreScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRefundScreenOpened() {
        return refundScreen.isElementPresent();
    }
}
