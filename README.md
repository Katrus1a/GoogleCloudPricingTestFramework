# GoogleCloudPricingTestFramework
Google Cloud Pricing Test Framework

This project is an automated test framework for validating the **Google Cloud Platform Pricing Calculator**. The framework automates:
- Searching for the **Google Cloud Pricing Calculator**.
- Filling out the pricing form with predefined parameters.
- Sending an estimate via email.
- Verifying that the emailed cost matches the estimated cost.

##  Key Features

 **Page Object Model (POM)** – structured and maintainable test architecture.  
 **Automated form filling** – enters all required fields for cloud pricing estimation.  
 **Email verification via Yopmail API** – checks that the estimate is sent correctly.  
 **Environment-based test configuration** – supports different environments via property files.  
 **Screenshot capturing on test failure** – stores test evidence for debugging.  
 **Parallel execution support** – executes tests efficiently across multiple browsers.

## 🛠 Technologies Used

- **Java** – Core language for test automation.
- **Selenium WebDriver** – Browser automation.
- **TestNG** (or JUnit) – Test execution framework.
- **Maven** – Dependency and build management.
- **Apache Commons Configuration** – Handles `config.properties` for test data.
- **Yopmail API** – Temporary email automation for estimate verification.
