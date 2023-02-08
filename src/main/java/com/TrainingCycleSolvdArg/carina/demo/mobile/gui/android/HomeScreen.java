package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {
    @FindBy(id = "com.mercadolibre:id/card_view_static_item")
    private ExtendedWebElement lastSeenProduct;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Menú\"]")
    private ExtendedWebElement menuIcon;

    //@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mercadolibre:id/im_button_row_universal_item']")
    @FindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.ImageView")
    private ExtendedWebElement superIcon;

    @ExtendedFindBy(accessibilityId = "Atrás")
    private ExtendedWebElement backArrow;

    @FindBy(id = "com.mercadolibre:id/ui_components_action_bar_title_toolbar")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.mercadolibre:id/vpp_action_bar_bookmark")
    private ExtendedWebElement bookMark;

    @FindBy(id = "com.mercadolibre:id/cart_icon")
    private ExtendedWebElement cartIcon;

    @FindBy(id = "com.mercadolibre:id/loy_offer_banner_cardview")
    private ExtendedWebElement offerBanner;

    @ExtendedFindBy(accessibilityId = "Atrás")
    private ExtendedWebElement backArrowIcon;

//    @FindBy(className = "androidx.recyclerview.widget.RecyclerView")
//    private ExtendedWebElement lastVisitedProduct;

    @FindBy(xpath = "//*[@resource-id='com.mercadolibre:id/rcm_portrait_card_thumbnail']")
    private ExtendedWebElement lastVisitedProduct;

    @FindBy(xpath = "//*[@resource-id='com.mercadolibre:id/ll_button_row_parent']")
    private ExtendedWebElement linearLayout;

    @ExtendedFindBy(text = "Televisores")
    private ExtendedWebElement fashionBtn;

    @ExtendedFindBy(text = "Videos")
    private ExtendedWebElement videosBtn;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductScreenBase clickOnLastSeenProduct() {
        lastSeenProduct.click();
        return initPage(getDriver(), ProductScreenBase.class);
    }

    @Override
    public MenuCatalogBase clickOnMenuIcon() {
        menuIcon.click();
        return initPage(getDriver(), MenuCatalogBase.class);
    }

    @Override
    public SuperMarketBase clickOnSuper() {
        superIcon.click();
        return initPage(getDriver(), SuperMarketBase.class);
    }

    @Override
    public void clickArrowBackButton() {
        backArrow.click();
    }

    @Override
    public void TapOnSearchBar() {
        searchBar.click();
    }

    @Override
    public void swipeDown() {
        swipe(bookMark, Direction.DOWN);
    }

    @Override
    public CartScreenBase clickOnCartIcon() {
        cartIcon.click();
        return initPage(getDriver(), CartScreenBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return offerBanner.isElementPresent();
    }

    @Override
    public List<WebElement> getLastVisitedProductAndClickOnIt() {
        List<WebElement> lastProducts = getDriver().findElements(lastVisitedProduct.getBy());
        lastProducts.get(0).click();
        return lastProducts;
    }

    @Override
    public List<WebElement> getSalesIconClick() {
        List<WebElement> salesList = getDriver().findElements(linearLayout.getBy());
        salesList.get(1).click();
        return salesList;
    }

    @Override
    public List<WebElement> clickOnCellPhoneSales() {
        List<WebElement> salesProducts = getDriver().findElements(linearLayout.getBy());
       salesProducts.get(3).click();
        return salesProducts;
    }

    @Override
    public List<WebElement> clickOnFashionSales() {
        List<WebElement> salesProducts = getDriver().findElements(linearLayout.getBy());
        salesProducts.get(4).click();
        return salesProducts;
    }

    @Override
    public ProductScreenBase clickOnBackArrowIcon() {
        backArrowIcon.click();
        return initPage(getDriver(), ProductScreenBase.class);
    }

    @Override
    public boolean backArrowPresent() {
        return backArrowIcon.isElementPresent();
    }

}
