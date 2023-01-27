package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AddedProductScreenBase.class)
public class AddedProductScreen extends AddedProductScreenBase {

    @FindBy(id = "com.mercadolibre:id/cart_congrats_title")
    private ExtendedWebElement congratsTitle;

    public AddedProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean getAddedProductCard() {
        return congratsTitle.isElementPresent();
    }


}
