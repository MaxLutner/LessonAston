package org.example.lesson2_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getFieldPlaceholder(By locator) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return input.getAttribute("placeholder");
    }

    public void fillField(By locator, String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));
        input.clear();
        input.sendKeys(value);
    }

    public boolean isPaymentIconPresent(By iconLocator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(iconLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickContinue() {
        By continueBtn = By.xpath("//*[@id=\"pay-connection\"]/button");
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public String getSumInConfirmation() {
        By sumLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__actions > div.pay-description__cost > span");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumLocator)).getText();
    }

    public String getPhoneNumberInConfirmation() {
        By phoneLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__text > span");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator)).getText();
    }
}