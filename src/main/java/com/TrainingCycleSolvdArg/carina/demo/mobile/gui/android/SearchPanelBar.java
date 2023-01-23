package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;


import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.ProductScreenBase;
import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.SearchPanelBarBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SearchPanelBar.class)
public class SearchPanelBar extends SearchPanelBarBase {

    @FindBy(id = "com.mercadolibre:id/search_input_edittext")
    private ExtendedWebElement typeInput;

    @FindBy(id = "com.mercadolibre:id/ui_components_action_bar_ic_search")
    private ExtendedWebElement searchIcon;

    @FindBy(id = "com.mercadolibre:id/search_input_cell_history_icon")
    private ExtendedWebElement productName;

    public SearchPanelBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeTheProduct(String product) {
    typeInput.type(product);
    }

    @Override
    public void clickOnSearchButton() {
        searchIcon.click();
    }

    @Override
    public ProductScreenBase clickOnProductsName() {
            productName.click();
            return initPage(getDriver(), ProductScreenBase.class);
    }


}
