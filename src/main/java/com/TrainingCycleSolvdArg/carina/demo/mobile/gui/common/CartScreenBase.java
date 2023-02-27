package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class CartScreenBase extends MercadolibreBase implements IMobileUtils {
    public CartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnEliminate();

    public abstract boolean isEliminateBtnPresent();

    public abstract boolean isEmptyCart();
}
