package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchPanelBarBase extends AbstractPage {
    public SearchPanelBarBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeTheProduct(String product);

    public abstract void clickOnSearchButton();

    public abstract ProductScreenBase clickOnProductsName();

}
