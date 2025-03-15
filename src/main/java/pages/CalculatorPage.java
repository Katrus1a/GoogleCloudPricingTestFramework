
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;





public class CalculatorPage {
    private final WebDriver driver = WebDriverFactory.getDriver();

    // Приклад локатора для лінка в результатах пошуку – у кроці 4 треба клікнути
    // "Google Cloud Platform Pricing Calculator":
    private final By calculatorLink = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div/div/div/div[3]/c-wiz/div[1]/div[1]/div/div[1]/a");
    // Локатор iframe, де розміщений калькулятор
    private final By calculatorIFrame = By.xpath("//iframe[contains(@src, 'calculator')]");
    // Локатор кнопки "Add to estimate"
    private final By addToEstimateButtonNew = By.xpath("//*[@id='ucj-1']/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/div/div/button/span[4]");

    // Приклад вкладки "Compute Engine"
    private final By computeEngineTab = By.xpath("//*[@id=\"yDmH0d\"]/div[6]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div");

    // Поля та селектори для заповнення (Number of instances, OS, Machine type і т.д.)
    private final By numberOfInstancesInput = By.xpath("//*[@id=\"c20\"]");
    // Наприклад, OS selector
    //private final By osSoftwareSelect = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");
    //private final By freeOsOption = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");

    // Provisioning model
    //private final By vmClassSelect = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");
    private final By regularOption = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[9]/div/div/div[2]/div/div/div[1]");

    // Machine Family -> Series N1
    private final By seriesSelect = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[1]/div/div/div/div[1]/div");
    private final By n1Option = By.xpath("//*[@id=\"c43\"]/li[1]");

    // Machine type -> n1-standard-8
    private final By machineTypeSelect = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div");
    private final By n1Standard8Option = By.xpath("//*[@id=\"c42\"]/li[7]");

    // Add GPUs checkbox
    private final By addGPUsCheckbox = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button/div/span[1]");
    private final By gpuTypeSelect = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]/div");
    private final By v100Option = By.xpath("//*[@id=\"c1942\"]/li[2]");
    private final By numberOfGpuSelect = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[24]/div/div[1]/div/div/div/div[1]/div");
    private final By oneGpuOption = By.xpath("//*[@id=\"c2062\"]/li[1]");

    // Local SSD (2x375 Gb)
    private final By ssdSelect = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]/div");
    private final By ssd2x375Option = By.xpath("//*[@id=\"c45\"]/li[3]");

    // Datacenter location (Frankfurt)
    //private final By locationSelect = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");
    //private final By frankfurtOption = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");

    // Committed usage: 1 Year
    //private final By committedUsageSelect = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");
    private final By oneYearOption = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]/label");

    // Кнопка 'Add to Estimate'
    private final By addToEstimateBtn = By.xpath("//*[@id=\"ow15\"]/div[2]/div/div/div/div/div/div[2]/div[1]/div/div[3]/div/button/span[3]");

    // Лейбл із текстом "Total Estimated Cost..."
    //private final By totalEstimatedCostText = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");

    // Кнопка EMAIL ESTIMATE
    //private final By emailEstimateBtn = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");

    // Поле для введення email
   // private final By emailInputField = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");

    // Кнопка SEND EMAIL
    //private final By sendEmailBtn = By.xpath("XPATH_ЗАМІНИТИ_ТУТ");


    public CalculatorPage clickCalculatorSearchResult() {
        if (driver.findElements(calculatorLink).size() > 0) {
            driver.findElement(calculatorLink).click();
        } else {
            System.out.println("Element not found: calculatorLink");
        }

        return this;
    }

    public CalculatorPage switchToCalculatorFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(calculatorIFrame));
        driver.switchTo().frame(frame);
        return this;
    }


    public CalculatorPage clickAddToEstimateNew() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButtonNew));
        addButton.click();
        return this;
    }



    public CalculatorPage selectComputeEngine() {
        driver.findElement(computeEngineTab).click();
        return this;
    }

    public CalculatorPage setNumberOfInstances(String number) {
        driver.findElement(numberOfInstancesInput).sendKeys(number);
        return this;
    }

//    public CalculatorPage setOperatingSystem() {
//        driver.findElement(osSoftwareSelect).click();
//        driver.findElement(freeOsOption).click();
//        return this;
//    }

//    public CalculatorPage setProvisioningModel() {
//        driver.findElement(vmClassSelect).click();
//        driver.findElement(regularOption).click();
//        return this;
//    }
//
//    public CalculatorPage setSeries() {
//        driver.findElement(seriesSelect).click();
//        driver.findElement(n1Option).click();
//        return this;
//    }
//
//    public CalculatorPage setMachineType() {
//        driver.findElement(machineTypeSelect).click();
//        driver.findElement(n1Standard8Option).click();
//        return this;
//    }
//
//    public CalculatorPage addGpu() {
//        driver.findElement(addGPUsCheckbox).click();
//        driver.findElement(gpuTypeSelect).click();
//        driver.findElement(v100Option).click();
//
//        driver.findElement(numberOfGpuSelect).click();
//        driver.findElement(oneGpuOption).click();
//        return this;
//    }
//
//    public CalculatorPage setLocalSsd() {
//        driver.findElement(ssdSelect).click();
//        driver.findElement(ssd2x375Option).click();
//        return this;
//    }
//
//    public CalculatorPage setDatacenterLocation() {
//        driver.findElement(locationSelect).click();
//        driver.findElement(frankfurtOption).click();
//        return this;
//    }
//
//    public CalculatorPage setCommittedUsage() {
//        driver.findElement(committedUsageSelect).click();
//        driver.findElement(oneYearOption).click();
//        return this;
//    }
//
//    public CalculatorPage clickAddToEstimate() {
//        driver.findElement(addToEstimateBtn).click();
//        return this;
//    }
//
//    public String getTotalEstimatedCostText() {
//        return driver.findElement(totalEstimatedCostText).getText();
//    }
//
//    public CalculatorPage clickEmailEstimate() {
//        driver.findElement(emailEstimateBtn).click();
//        return this;
//    }
//
//    public CalculatorPage enterEmail(String email) {
//        driver.findElement(emailInputField).sendKeys(email);
//        return this;
//    }
//
//    public CalculatorPage sendEmail() {
//        driver.findElement(sendEmailBtn).click();
//        return this;
//    }
}
