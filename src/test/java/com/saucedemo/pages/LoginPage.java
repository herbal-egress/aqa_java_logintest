package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Page Object для страницы логина. Содержит локаторы и методы взаимодействия.
@Slf4j
public class LoginPage extends BasePage {

    @FindBy(css = "[data-test=username]")
    private WebElement usernameField;

    @FindBy(css = "[data-test=password]")
    private WebElement passwordField;

    @FindBy(css = "[data-test=login-button]")
    private WebElement loginButton;

    @FindBy(css = "[data-test=error]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        log.info("Введён username: {}", username.isEmpty() ? "<пусто>" : username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log.info("Введён password: {}", password.isEmpty() ? "<пусто>" : "*****");
    }

    public void clickLogin() {
        loginButton.click();
        log.info("Нажата кнопка Login");
    }

    public String getErrorMessage() {
        String text = errorMessage.getText();
        log.info("Получено сообщение об ошибке: {}", text);
        return text;
    }
}