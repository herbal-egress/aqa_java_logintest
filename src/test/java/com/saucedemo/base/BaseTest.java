package com.saucedemo.base;

import com.saucedemo.utils.BrowserFactory;
import com.saucedemo.utils.ScreenshotUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

// Базовый тестовый класс. Управляет жизненным циклом WebDriver и скриншотами.
@Slf4j
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        log.info("Запущен браузер: {}", browser);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            ScreenshotUtils.takeScreenshotOnFailure(driver); // Автоматический скриншот при падении
            driver.quit();
            log.info("Браузер закрыт");
        }
    }
}