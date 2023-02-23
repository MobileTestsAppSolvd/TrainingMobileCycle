package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.PaymentOptionsScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentOptionsScreenBase.class)
public class PaymentOptionsScreen extends PaymentOptionsScreenBase {
    @ExtendedFindBy(text = "Medios de pago para este producto")
    private ExtendedWebElement paymentOptionsText;

    public PaymentOptionsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPaymentOptionScreenShown() {
        return paymentOptionsText.isElementPresent();
    }
}
