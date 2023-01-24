package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductoAgregadoScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ProductoAgregadoScreenBase.class)
public class ProductoAgregadoScreen extends ProductoAgregadoScreenBase {

    @FindBy(id = "com.mercadolibre:id/cart_congrats_title")
    private ExtendedWebElement congratsTitle;

    public ProductoAgregadoScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getAddedProductMessage() {
        return congratsTitle.getText();
    }
}
