package com.saucedemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Фабрика для создания WebDriver с автоматическим управлением драйверами.
@Slf4j
public class BrowserFactory {

    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                log.info("Настроен ChromeDriver");
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                log.info("Настроен GeckoDriver");
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException("Не поддерживаемый браузер: " + browserName);
        }
    }
}