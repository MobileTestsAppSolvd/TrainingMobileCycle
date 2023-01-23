package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SuperMercadoBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SuperMercadoPanel.class)
public class SuperMercadoPanel extends SuperMercadoBase {
    public SuperMercadoPanel(WebDriver driver) {
        super(driver);
    }

}
