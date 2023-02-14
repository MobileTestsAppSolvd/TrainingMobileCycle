package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.*;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.LEFT;

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

    @ExtendedFindBy(text = "Vehículos")
    private ExtendedWebElement vehiclesBtn;

    @FindBy(xpath = "//*[@resource-id='com.mercadolibre:id/ll_button_row_parent']")
    private ExtendedWebElement linearLayout;

    @ExtendedFindBy(text = "Televisores")
    private ExtendedWebElement tvBtn;

    @ExtendedFindBy(text = "Pagos QR")
    private ExtendedWebElement pagoQr;

    @ExtendedFindBy(text = "Videos")
    private ExtendedWebElement videosBtn;

    @ExtendedFindBy(text = "Más vendidos")
    private ExtendedWebElement moreSold;

    @ExtendedFindBy(text = "Moda")
    private ExtendedWebElement fashionBtn;


    @ExtendedFindBy(text = "Ofertas")
    private ExtendedWebElement salesBtn;

    @ExtendedFindBy(text = "Celulares")
    private ExtendedWebElement cellPhoneBtn;

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
    public VideosScreenBase tapOnVideoBtn() {
        videosBtn.click();
        return initPage(getDriver(), VideosScreenBase.class);
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
    public CellPhoneSalesBase clickOnCellPhoneSales() {
        cellPhoneBtn.click();
        return initPage(getDriver(), CellPhoneSalesBase.class);
    }


    @Override
    public FashionScreenBase clickOnFashionSales() {
        fashionBtn.click();
        return initPage(getDriver(), FashionScreenBase.class);
    }

    @Override
    public ProductScreenBase clickOnBackArrowIcon() {
        backArrowIcon.click();
        return initPage(getDriver(), ProductScreenBase.class);
    }

    @Override
    public boolean isBackArrowPresent() {
        return backArrowIcon.isElementPresent();
    }

    @Override
    public List<ExtendedWebElement> findExtendedWebElements(By by) {
        List<ExtendedWebElement> extendedWebElements = findExtendedWebElements(linearLayout.getBy(), 5000);
        return extendedWebElements;
    }

    @Override
    public VehiclesScreenBase clickOnVehiclesBtn() {
        vehiclesBtn.click();
        return initPage(getDriver(), VehiclesScreenBase.class);
    }

    @Override
    public void swipeLeftFashionBtn() {
        dragAndDrop(fashionBtn, pagoQr);
    }

    @Override
    public MoreSoldScreenBase clickOnMoreSoldBtn() {
        moreSold.click();
        return initPage(getDriver(), MoreSoldScreenBase.class);
    }

    @Override
    public SalesScreenBase clickOnSales() {
       salesBtn.click();
        return initPage(getDriver(), SalesScreenBase.class);
    }


}
