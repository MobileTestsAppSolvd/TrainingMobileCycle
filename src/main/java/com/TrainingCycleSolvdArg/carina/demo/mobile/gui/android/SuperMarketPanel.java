package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SuperMarketBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SuperMarketBase.class)
public class SuperMarketPanel extends SuperMarketBase {

    @ExtendedFindBy(text = "Supermercado")
    //or we can type the following wich is the same
    // @FindBy(xpath = "//android.widget.TextView[@text = 'Supermercado']")
    private ExtendedWebElement textSuper;
    public SuperMarketPanel(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSuperCardPresent() {
        return textSuper.isElementPresent();
    }





}
