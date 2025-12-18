package com.saucedemo.utils;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

// Утилита для создания скриншотов и прикрепления к Allure.
@Slf4j
public class ScreenshotUtils {

    public static void takeScreenshotOnFailure(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Скриншот при падении теста", "image/png", new ByteArrayInputStream(screenshot), ".png");
            log.info("Сделан и прикреплён скриншот к отчёту");
        }
    }
}