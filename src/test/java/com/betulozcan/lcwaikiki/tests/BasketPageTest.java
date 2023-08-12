
package com.betulozcan.lcwaikiki.tests;

import com.betulozcan.lcwaikiki.pages.BasketPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasketPageTest extends BaseTest {

    @Test
    public void addToBasketTest() {
        BasketPage basketPage = new BasketPage(driver);

        // Check title has contains "LC Waikiki"
        Assert.assertTrue(driver.getTitle().contains("LC Waikiki"));


        // Get the category page details
        String categoryUrl = basketPage.getUrl(basketPage.categoryLink);
        String categoryText = basketPage.getText(basketPage.categoryLink);

        // Visit the category page
        basketPage.clickCategory();

        // Compare current page to selected category
        Assert.assertEquals(driver.getCurrentUrl(), categoryUrl);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(categoryText.toLowerCase()));


        // Get the product details
        String productUrl = basketPage.getUrl(basketPage.productLink);
        String productText = basketPage.getText(basketPage.productTitle);

        // Visit the product page
        basketPage.clickProduct();

        // Compare current page to selected product
        Assert.assertEquals(driver.getCurrentUrl(), productUrl);
        Assert.assertTrue(driver.getTitle().contains(productText));

        // Wait close Select Sizer Popup
        basketPage.waitCloseSelectPopup();

        // If it has a sizes, select the first available size
        if (basketPage.hasSelectSize()) {
            basketPage.clickSelectSize();
        }

        // Add the product to the cart and wait until it is added
        basketPage.clickAddToBasket();

        // Compare "add to cart button" title is changed
        Assert.assertEquals(basketPage.getText(basketPage.addToBasket), "SEPETE EKLENDİ");


        // Get the basket page details
        String basketUrl = basketPage.getUrl(basketPage.basketLink);
        String basketText = "Sepetim";

        // Get the added product details
        String productCode = basketPage.getText(basketPage.productCode);

        // Visit the basket page
        basketPage.clickBasket();

        // Compare current page to basket page
        Assert.assertEquals(driver.getCurrentUrl(), basketUrl);
        Assert.assertTrue(driver.getTitle().contains(basketText));

        // Compare product on basket  to the added product
        Assert.assertTrue(productCode.contains(basketPage.getText(basketPage.productCodeOnBasket)));

        // Get the home page details
        String homePageUrl = basketPage.getUrl(basketPage.homeLink);

        // Visit the home page
        basketPage.clickHomePage();

        // Compare home page
        Assert.assertEquals(driver.getCurrentUrl(), homePageUrl);
    }
}
