package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsScreenBase extends AbstractPage {
    public SearchResultsScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFilterBtnPresent();

}
