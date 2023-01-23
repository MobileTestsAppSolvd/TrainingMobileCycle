package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.CarritoScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = CarritoScreenBase.class)
public class CarritoScreen extends CarritoScreenBase {

    @ExtendedFindBy(text = "Eliminar")
    private ExtendedWebElement eliminarButton;

    @ExtendedFindBy(text = "Carrito (0)")
    private ExtendedWebElement carritoItems;

    public CarritoScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnEleminar() {
        eliminarButton.click();
    }

    @Override
    public String getCarritoItems() {
        return carritoItems.getText();
    }
}
