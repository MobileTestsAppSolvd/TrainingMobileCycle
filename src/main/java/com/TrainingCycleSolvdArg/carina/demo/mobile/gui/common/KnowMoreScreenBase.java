package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class KnowMoreScreenBase extends AbstractPage {
    public KnowMoreScreenBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isRefundScreenOpened();
}
