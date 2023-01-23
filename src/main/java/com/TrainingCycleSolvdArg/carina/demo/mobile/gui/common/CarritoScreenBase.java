package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CarritoScreenBase extends AbstractPage {
    public CarritoScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnEleminar();

    public abstract String getCarritoItems();

}
