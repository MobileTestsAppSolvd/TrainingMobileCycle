package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CartScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    @FindBy(id = "com.mercadolibre:id/cart_item_first_secondary_action_text_view")
    private ExtendedWebElement eliminateButton;

    @FindBy(id = "com.mercadolibre:id/cart_empty_items_view_title")
    private ExtendedWebElement emptyCard;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnEleminate() {
        eliminateButton.click();
    }

    @Override
    public boolean getEmptyCard() {
        return emptyCard.isElementPresent();
    }


}
