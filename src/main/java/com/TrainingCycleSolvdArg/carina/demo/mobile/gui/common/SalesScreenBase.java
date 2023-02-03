package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SalesScreenBase extends AbstractPage {
    public SalesScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSalesScreenOpened();
}
