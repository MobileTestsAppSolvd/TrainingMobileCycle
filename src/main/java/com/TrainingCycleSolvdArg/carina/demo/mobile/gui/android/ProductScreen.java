package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.PaymentOptionsScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.KnowMoreScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ShippingOptionsScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    @ExtendedFindBy(text = "Cartera shopper Kalton Bags 9025 diseño liso de cuero sintético  negra asas color negro")
    private ExtendedWebElement firstProduct;
    @ExtendedFindBy(text = "Agregar al carrito")
    private ExtendedWebElement addToCartButton;
    @ExtendedFindBy(text = "Comprar ahora")
    private ExtendedWebElement productColor;
    @ExtendedFindBy(text = "Comprar ahora")
    private ExtendedWebElement buyNowBtn;
    @FindBy(id = "com.mercadolibre:id/generic_summary_subtitle")
    private ExtendedWebElement KnowMoreButton;
    @ExtendedFindBy(text = "Conocer más")
    private ExtendedWebElement KnowMore;
    @FindBy(id = "com.mercadolibre:id/price_component_action")
    private ExtendedWebElement viewPaymentOptionsBtn;
    @ExtendedFindBy(text = "Ver más formas de entrega")
    private ExtendedWebElement viewShippingOptionsBtn;
    @FindBy(id = "com.mercadolibre:id/andes_button_text")
    private ExtendedWebElement buyNowButton;
    @FindBy(id = "com.mercadolibre:id/header_component_title")
    private ExtendedWebElement productTitle;
    @FindBy(id = "com.mercadolibre:id/gallery_image")
    private ExtendedWebElement productImage;
    @FindBy(id = "com.mercadolibre:id/andes_money_amount")
    private ExtendedWebElement productPrice;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnTheFirstProduct() {
        firstProduct.click();
    }

    @Override
    public void swipeUp() {
        swipe(productColor, Direction.UP);
    }

    @Override
    public AddedProductScreenBase clickOnAgregarAlCarrito() {
        return null;
    }

    @Override
    public AddedProductScreenBase clickOnAddToCart() {
        addToCartButton.click();
        return initPage(getDriver(), AddedProductScreenBase.class);
    }

    @Override
    public void clickOnBuyNow() {
        swipe(buyNowBtn, Direction.UP);
        buyNowBtn.click();
    }

    @Override
    public boolean isKnowMoreButtonPresent() {
        return KnowMoreButton.isElementPresent();
    }

    @Override
    public boolean isKnowMoreButtonNOTPresent() {
        KnowMoreButton.isElementNotPresent(5);
        return true;
    }

    @Override
    public boolean isBuyNowButtonPresent() {
        return buyNowButton.isElementPresent();
    }

    @Override
    public KnowMoreScreenBase clickOnKnowMoreButton() {
        KnowMore.click();
        return initPage(getDriver(), KnowMoreScreenBase.class);
    }

    @Override
    public PaymentOptionsScreenBase clickOnViewPaymentOptionsBtn() {

        swipe(viewPaymentOptionsBtn, Direction.UP);
        viewPaymentOptionsBtn.click();
        return initPage(getDriver(), PaymentOptionsScreenBase.class);
    }

    @Override
    public ShippingOptionsScreenBase clickOnViewShippingOptionsBtn() {
        swipe(viewShippingOptionsBtn, Direction.UP);
        viewShippingOptionsBtn.click();
        return initPage(getDriver(), ShippingOptionsScreenBase.class);
    }

    @Override
    public void KnowMoreButtonError(String message) {
        throw new AssertionError(message);
    }

    @Override
    public boolean areElementsPresent() {
        List<ExtendedWebElement> list = new ArrayList<>();
        list.add(productImage);
        list.add(productTitle);
        list.add(productPrice);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                return false;
            }
        }
        return true;
    }
}
