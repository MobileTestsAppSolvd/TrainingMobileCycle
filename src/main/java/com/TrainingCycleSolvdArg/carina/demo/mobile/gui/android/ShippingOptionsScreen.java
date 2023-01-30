package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.PaymentOptionsScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ShippingOptionsScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ShippingOptionsScreenBase.class)
public class ShippingOptionsScreen extends ShippingOptionsScreenBase{

    @ExtendedFindBy(text = "Opciones de envío y retiro")
    private ExtendedWebElement shippingOptionsTxt;


    public ShippingOptionsScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isShippingOptionsShown() {
        return shippingOptionsTxt.isElementPresent();
    }
}
