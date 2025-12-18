# Автоматизация тестирования логина на SauceDemo

Тестовое задание: автоматизированные UI-тесты для сайта https://www.saucedemo.com/ с использованием Selenium WebDriver и Java.

## Описание проекта
- Реализовано **5 независимых тестов** на разные сценарии авторизации:
    1. Успешный логин (standard_user / secret_sauce)
    2. Неверный пароль
    3. Заблокированный пользователь (locked_out_user)
    4. Пустые поля
    5. performance_glitch_user (с учётом задержек)
- Использован **Page Object Model** (POM)
- Кросс-браузерное тестирование: Chrome, Firefox, Edge, Opera, Vivaldi (все Chromium-based браузеры работают через параметр chrome)
- Подробное логирование на русском языке (@Slf4j)
- Автоматические скриншоты при падении тестов в Allure
- Отчёты: Allure Reports

## Требования
- Java 17
- Maven 3.8+
- Установленные браузеры: Chrome и/или Firefox (для других — используйте chrome)

## Запуск тестов
```bash
# Очистка и запуск всех тестов (по умолчанию в Chrome)
mvn clean test

# Запуск в Firefox
mvn clean test -Dbrowser=firefox

# Запуск в Edge / Opera / Vivaldi (Chromium-based)
mvn clean test -Dbrowser=chrome
```
## Генерация и просмотр Allure-отчёта
После выполнения тестов:
```bash
mvn allure:serve
```