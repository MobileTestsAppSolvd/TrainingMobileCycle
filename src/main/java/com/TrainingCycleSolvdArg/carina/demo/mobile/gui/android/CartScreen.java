package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {
    @FindBy(id = "com.mercadolibre:id/cart_item_first_secondary_action_text_view")
    private ExtendedWebElement eliminateButton;
    @FindBy(id = "com.mercadolibre:id/cart_empty_items_view_title")
    private ExtendedWebElement emptyCartTxt;
    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    private ExtendedWebElement cartElements;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnEleminate() {
        eliminateButton.click();
    }

    @Override
    public boolean isEmptyCart() {
        return emptyCartTxt.isElementPresent();
    }

    @Override
    public boolean areCartElementsPresent() {
        List<ExtendedWebElement> list = findExtendedWebElements(cartElements.getBy(), 5000);
        return list.get(0).isElementPresent() && list.get(1).isElementPresent();
    }

}
