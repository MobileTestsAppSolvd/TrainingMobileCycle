package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class MenuCatalogBase extends AbstractPage implements IMobileUtils {

    public MenuCatalogBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCuentaText();

    public abstract HomeScreenBase clickOnInicio();
}
