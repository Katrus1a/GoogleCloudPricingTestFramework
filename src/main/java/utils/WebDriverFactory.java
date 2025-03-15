package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
        // Забороняємо створення екземплярів класу
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Використовуємо WebDriverManager для автоматичного встановлення драйвера
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
