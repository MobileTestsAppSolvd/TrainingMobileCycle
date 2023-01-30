package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class SuperMarketBase extends AbstractPage implements IMobileUtils {
    public SuperMarketBase(WebDriver driver) {
        super(driver);
    }
    public abstract String getSuperText();
}
