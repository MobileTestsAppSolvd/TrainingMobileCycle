package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class MercadolibreBase extends AbstractPage implements IMobileUtils {
    public MercadolibreBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean areMainElementsPresent();
}
