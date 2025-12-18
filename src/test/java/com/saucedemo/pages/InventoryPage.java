package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page Object для страницы инвентаря после успешного логина.
@Slf4j
public class InventoryPage extends BasePage {

    @FindBy(css = "span.title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        wait.until(ExpectedConditions.visibilityOf(inventoryList));
        boolean opened = pageTitle.getText().equals("Products") && inventoryList.isDisplayed();
        log.info("Страница инвентаря открыта: {}", opened);
        return opened;
    }
}