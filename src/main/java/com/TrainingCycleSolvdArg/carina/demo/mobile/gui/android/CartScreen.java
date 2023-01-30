package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    @ExtendedFindBy(text = "Eliminar")
    private ExtendedWebElement eliminateButton;

    @ExtendedFindBy(text = "Carrito (0)")
    private ExtendedWebElement cartItems;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnEleminate() {
        eliminateButton.click();
    }

    @Override
    public String getCartItems() {
        return cartItems.getText();
    }
}
