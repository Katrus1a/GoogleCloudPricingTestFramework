package tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.CloudHomePage;
import utils.WebDriverFactory;
import org.testng.annotations.AfterClass;

public class GoogleCloudTest {

    private CloudHomePage cloudHomePage;
    private CalculatorPage calculatorPage;

    @BeforeClass
    public void setUp() {
        // Отримуємо WebDriver перед ініціалізацією сторінок
        WebDriverFactory.getDriver();

        // Ініціалізуємо сторінки після створення WebDriver
        cloudHomePage = new CloudHomePage();
        calculatorPage = new CalculatorPage();
    }
    @Test
    public void testGoogleCloudPricingEmail() throws InterruptedException {
        // 1. Open https://cloud.google.com/
        cloudHomePage.openHomePage();

        // 2. Click on the icon at the top of the portal page and enter "Google Cloud Platform Pricing Calculator"
        cloudHomePage.clickSearchIcon()
                .enterSearchTerm("Google Cloud Platform Pricing Calculator");

        // 3. Perform the search
        cloudHomePage.submitSearch();

        // 4. Click "Google Cloud Platform Pricing Calculator" and go to the calculator page
        calculatorPage.clickCalculatorSearchResult();
        calculatorPage.clickAddToEstimateNew();


        // 5. Now switch to iFrame and click COMPUTE ENGINE
        calculatorPage.switchToCalculatorFrame()
                .selectComputeEngine();

        // 6. Fill out the form:
        calculatorPage.setNumberOfInstances("4");
        // Закоментовані інші поля
        // calculatorPage.setOperatingSystem();
        // calculatorPage.setProvisioningModel();
        // calculatorPage.setSeries();
        // calculatorPage.setMachineType();
        // calculatorPage.addGpu();
        // calculatorPage.setLocalSsd();
        // calculatorPage.setDatacenterLocation();
        // calculatorPage.setCommittedUsage();

        // Закоментовано функціонал після 6-го пункту
        // 7. Click 'Add to Estimate'
        // calculatorPage.clickAddToEstimate();

        // 8. Check the price is calculated
        // String totalCostText = calculatorPage.getTotalEstimatedCostText();
        // System.out.println("Calculator shows cost: " + totalCostText);
        // Assert.assertTrue(totalCostText.contains("Total Estimated Cost"),
        //        "Відсутній текст 'Total Estimated Cost'!");

        // 9. Select 'EMAIL ESTIMATE'
        // calculatorPage.clickEmailEstimate();

        // 10. Open Yopmail in a new tab
        // String originalTab = WebDriverFactory.getDriver().getWindowHandle();
        // ((org.openqa.selenium.JavascriptExecutor) WebDriverFactory.getDriver())
        //        .executeScript("window.open('https://yopmail.com/', '_blank');");

        // Перемикаємося на нову вкладку
        // Set<String> allTabs = WebDriverFactory.getDriver().getWindowHandles();
        // for (String tab : allTabs) {
        //    if (!tab.equals(originalTab)) {
        //        WebDriverFactory.getDriver().switchTo().window(tab);
        //        break;
        //    }
        // }

        // 11. Generate random email
        // yopMailPage.clickEmailGenerator();
        // Thread.sleep(2000);
        // String generatedEmail = yopMailPage.copyGeneratedEmail();
        // System.out.println("Generated email: " + generatedEmail);

        // 12. Повертаємось у калькулятор
        // WebDriverFactory.getDriver().switchTo().window(originalTab);
        // calculatorPage.switchToCalculatorFrame();

        // 13. Enter the above email
        // calculatorPage.enterEmail(generatedEmail);

        // 14. Press 'SEND EMAIL'
        // calculatorPage.sendEmail();

        // 15. Wait for the cost estimate email and check
        // WebDriverFactory.getDriver().switchTo().window(allTabs.stream().filter(t -> !t.equals(originalTab)).findFirst().get());
        // Thread.sleep(3000);

        // for (int i = 0; i < 5; i++) {
        //    yopMailPage.refreshInbox();
        //    Thread.sleep(5000);
        //    try {
        //        yopMailPage.openIncomingEmail();
        //        break;
        //    } catch (Exception e) {
        //    }
        // }

        // String emailBody = yopMailPage.readEmailBody();
        // System.out.println("Email body:\n" + emailBody);
        // Assert.assertTrue(emailBody.contains("Total Estimated Monthly Cost"),
        //        "У листі відсутній текст 'Total Estimated Monthly Cost'!");
    }

    // Закоментував @AfterClass, щоб уникнути проблем із WebDriver
    @AfterClass
    public void tearDown() {
        // Закриваємо WebDriver після завершення тесту
        WebDriverFactory.quitDriver();
    }
}
