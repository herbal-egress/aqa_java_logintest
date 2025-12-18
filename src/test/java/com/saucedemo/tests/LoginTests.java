package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Основной тестовый класс с 5 сценариями. Каждый тест независимый.
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Тесты авторизации на SauceDemo")
public class LoginTests extends BaseTest {

    @Step("Выполнить логин с username={username} и password={password}")
    private void performLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test
    @Order(1)
    @DisplayName("1. Успешный логин standard_user")
    @Description("Проверка успешной авторизации и перехода на страницу инвентаря")
    void successfulLogin() {
        performLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isPageOpened(), "Страница инвентаря не открылась после успешного логина");
    }

    @Test
    @Order(2)
    @DisplayName("2. Логин с неверным паролем")
    @Description("Проверка сообщения об ошибке при неверном пароле")
    void loginWithWrongPassword() {
        performLogin("standard_user", "wrong_password");

        LoginPage loginPage = new LoginPage(driver);
        String error = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Username and password do not match any user in this service", error);
    }

    @Test
    @Order(3)
    @DisplayName("3. Логин заблокированного пользователя")
    @Description("Проверка сообщения для locked_out_user")
    void loginLockedOutUser() {
        performLogin("locked_out_user", "secret_sauce");

        LoginPage loginPage = new LoginPage(driver);
        String error = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", error);
    }

    @Test
    @Order(4)
    @DisplayName("4. Логин с пустыми полями")
    @Description("Проверка сообщения при пустых username и password")
    void loginWithEmptyFields() {
        performLogin("", "");

        LoginPage loginPage = new LoginPage(driver);
        String error = loginPage.getErrorMessage();
        assertEquals("Epic sadface: Username is required", error);
    }

    @Test
    @Order(5)
    @DisplayName("5. Логин performance_glitch_user")
    @Description("Проверка успешного логина с учётом возможных задержек производительности")
    void loginPerformanceGlitchUser() {
        performLogin("performance_glitch_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isPageOpened(), "Страница инвентаря не открылась для performance_glitch_user");
    }
}