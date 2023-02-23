package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class MenuCatalogBase extends MercadolibreBase implements IMobileUtils {
    public MenuCatalogBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getBarTitle();

    public abstract HomeScreenBase clickOnHome();
}
