package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class ProductScreenBase extends MercadolibreBase implements IMobileUtils {
    public ProductScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnTheFirstProduct();

    public abstract void swipeUp();

    public abstract void clickOnBuyNow();

    public abstract AddedProductScreenBase clickOnAddToCart();

    public abstract boolean isKnowMoreButtonPresent();

    public abstract boolean isKnowMoreButtonNOTPresent();

    public abstract boolean isBuyNowButtonPresent();

    public abstract KnowMoreScreenBase clickOnKnowMoreButton();

    public abstract PaymentOptionsScreenBase clickOnViewPaymentOptionsBtn();

    public abstract ShippingOptionsScreenBase clickOnViewShippingOptionsBtn();

    public abstract void KnowMoreButtonError(String message);
}
