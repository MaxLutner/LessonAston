package org.example.lesson2_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationDialog {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ConfirmationDialog(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.confirmation-dialog"))).isDisplayed();
    }
}
