package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CellPhoneSalesBase extends AbstractPage {
    public CellPhoneSalesBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCellPhoneScreenOpened();
}
