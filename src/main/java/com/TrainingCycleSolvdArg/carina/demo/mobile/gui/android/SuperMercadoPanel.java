package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SuperMercadoBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SuperMercadoBase.class)
public class SuperMercadoPanel extends SuperMercadoBase {
    public SuperMercadoPanel(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(text = "Supermercado")
    //or we can type the following wich is the same
  // @FindBy(xpath = "//android.widget.TextView[@text = 'Supermercado']")
    private ExtendedWebElement textSuper;

    @Override
    public String getSuperText() {
      return textSuper.getText();
    }

}
