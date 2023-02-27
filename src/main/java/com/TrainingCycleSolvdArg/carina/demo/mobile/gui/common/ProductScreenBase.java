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
    public abstract boolean isAddToCartBtnPresent();

    public abstract boolean isKnowMoreButtonPresent();

    public abstract KnowMoreScreenBase clickOnKnowMoreButton();

    public abstract PaymentOptionsScreenBase clickOnViewPaymentOptionsBtn();

    public abstract ShippingOptionsScreenBase clickOnViewShippingOptionsBtn();
}
