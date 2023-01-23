package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class HomeScreenBase extends AbstractPage implements IMobileUtils {

    public HomeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuCatalogBase clickOnMenuIcon();

    public abstract SuperMercadoBase clickOnSuper();

    public abstract void clickArrowBackButton();

    // public abstract SearchPanelBarBase TapOnSearchBar();
    public abstract void TapOnSearchBar();

    public abstract void swipeDown();

    public abstract CarritoScreenBase clickOnCarritoIcon();
}
