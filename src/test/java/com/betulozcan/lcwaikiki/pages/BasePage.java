package com.betulozcan.lcwaikiki.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By element){
        return webDriver.findElement(element);
    }

    public String getText(By element) {
        return findElement(element).getText();
    }

    public String getUrl(By by) {
        return findElement(by).getAttribute("href");
    }

    public void clickElement(By element) {
        elementClickable(element);
        findElement(element).click();
    }

    public void elementClickable(By by) {
        WebElement webElement = findElement(by);

        new Actions(webDriver)
                .scrollToElement(webElement)
                .perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
