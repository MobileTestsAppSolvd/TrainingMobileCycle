package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FashionScreenBase extends AbstractPage {
    public FashionScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFashionScreenOpened();
}
