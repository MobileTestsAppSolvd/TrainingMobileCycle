package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android.SuperMercadoPanel;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class HomeScreenBase extends AbstractPage implements IMobileUtils {
    public HomeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuCatalogBase clickOnMenuIcon();

    public abstract SuperMercadoPanel clickOnSuper();
}
