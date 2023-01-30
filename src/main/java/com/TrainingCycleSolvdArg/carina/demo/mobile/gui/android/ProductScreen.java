package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.AddedProductScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {

    @ExtendedFindBy(text = "Cartera shopper Kalton Bags 9025 diseño liso de cuero sintético  negra asas color negro")
    private ExtendedWebElement firstProduct;

    @ExtendedFindBy(text = "Agregar al carrito")
    private ExtendedWebElement agregarAlCarritoButton;

    @ExtendedFindBy(text = "Comprar ahora")
    private ExtendedWebElement productColor;
    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnTheFirstProduct() {
    firstProduct.click();
    }

    @Override
    public void swipeUp() {
        swipe(productColor,Direction.UP);
    }

    @Override
    public AddedProductScreenBase clickOnAgregarAlCarrito() {
        agregarAlCarritoButton.click();
        return initPage(getDriver(), AddedProductScreenBase.class);
    }


}
