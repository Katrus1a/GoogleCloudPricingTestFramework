package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class CloudHomePage {

    private final WebDriver driver = WebDriverFactory.getDriver();

    // Іконка пошуку (лупа)
    private final By searchIcon = By.xpath("//*[@id='kO001e']/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div");

    // Поле пошуку
    private final By searchInput = By.xpath("//*[@id='i3']");

    public CloudHomePage openHomePage() {
        driver.get("https://cloud.google.com/");
        return this;
    }

    public CloudHomePage clickSearchIcon() {
        driver.findElement(searchIcon).click();
        return this;
    }

    public CloudHomePage enterSearchTerm(String text) {
        driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public void submitSearch() {
        // Натискаємо Enter для виконання пошуку
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }
}
