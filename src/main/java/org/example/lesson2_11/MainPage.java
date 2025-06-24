package org.example.lesson2_11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
    }

    public void acceptCookies() {
        By acceptBtn = By.xpath("//button[contains(text(), 'Принять')]");
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(acceptBtn));
            btn.click();
        } catch (TimeoutException e) {
            System.out.println("Окно Cookies не отображается или уже закрыто.");
        }
    }

    public void scrollToPaymentSection() {
        By sectionHeader = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(sectionHeader));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getSelectedService() {
        By selectedItem = By.cssSelector("div.select__wrapper");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectedItem)).getText();
    }

    public void selectService(String serviceName) {

        By wrapper = By.cssSelector("div.select__wrapper");
        WebElement wrapperEl = wait.until(ExpectedConditions.elementToBeClickable(wrapper));
        wrapperEl.click();
        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//section[@class='pay']//ul[@class='select__list']//li//p[contains(text(),'" + serviceName + "')]"))));
        dropDown.click();
    }

}