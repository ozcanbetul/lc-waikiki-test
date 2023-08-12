
package com.betulozcan.lcwaikiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.*;

public class BasketPage extends BasePage {
    public By categoryLink = cssSelector(".menu-header-item--outlet a");
    public By productLink = cssSelector(".product-card a");
    public By productTitle = cssSelector(".product-card .product-card__title");
    public By addToBasket = id("pd_add_to_cart");
    public By selectSize = cssSelector("#option-size a:not(.disabledNotSelected)");
    public By selectPopupBackground = className("exploreBodyContainer-bg");
    public By basketLink = cssSelector(".header-section > .cart-dropdown:last-child a");
    public By productCode = cssSelector(".info-panel-content .product-code");
    public By productCodeOnBasket = className("rd-cart-item-code");
    public By homeLink = className("main-header-logo");

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickCategory() {
        clickElement(categoryLink);
    }

    public void clickProduct() {
        clickElement(productLink);
    }

    public void clickBasket() {
        clickElement(basketLink);
    }

    public void clickHomePage() {
        clickElement(homeLink);
    }

    public void clickAddToBasket() {
        clickElement(addToBasket);
        webDriverWait.until(ExpectedConditions.textToBe(addToBasket, "SEPETE EKLENDİ"));
    }

    public void clickSelectSize() {
        clickElement(selectSize);
    }

    public boolean hasSelectSize() {
        return ! webDriver.findElements(selectSize).isEmpty();
    }

    public void waitCloseSelectPopup() {
        webDriverWait.until(ExpectedConditions.invisibilityOf(findElement(selectPopupBackground)));
    }
}
