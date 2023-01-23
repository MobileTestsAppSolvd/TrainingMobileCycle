package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductoAgregadoScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ProductoAgregadoScreenBase.class)
public class ProductoAgregadoScreen extends ProductoAgregadoScreenBase {
    public ProductoAgregadoScreen(WebDriver driver) {
        super(driver);
    }
}
