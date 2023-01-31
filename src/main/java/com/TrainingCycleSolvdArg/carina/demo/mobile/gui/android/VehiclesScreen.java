package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.VehiclesScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = VehiclesScreenBase.class)
public class VehiclesScreen extends VehiclesScreenBase {

    @ExtendedFindBy(text = "Vehículos")
    private ExtendedWebElement vehiclesTxt;
    public VehiclesScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isVehiclesScreenShown() {
        return vehiclesTxt.isElementPresent();
    }
}
