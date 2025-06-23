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

    /*public void selectService(String serviceName) {
        By wrapper = By.cssSelector("div.select__wrapper");
        WebElement wrapperEl = wait.until(ExpectedConditions.elementToBeClickable(wrapper));
        wrapperEl.click();

        By options = By.cssSelector("div.select__wrapper.opened ul li");
        for (WebElement option : wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(options))) {
            if (option.findElement(By.tagName("p")).getText().equals(serviceName)) {
                option.click();
                break;
            }
        }
    }*/


    public void selectService(String serviceName) {
        // Селектор кнопки для открытия списка
        By toggleButton = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(toggleButton));
        button.click();

        // Массив селекторов вариантов
        String[] optionSelectors = {
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper.opened > ul > li.select__item.active > p",
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__form > div.select > div.select__wrapper.opened > ul > li:nth-child(2) > p",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p"
        };

        boolean found = false;

        for (String selector : optionSelectors) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
                String text = element.getText().trim();
                if (text.equals(serviceName)) {
                    element.click();
                    found = true;
                    break;
                }
            } catch (TimeoutException e) {
                // Элемент не найден по этому селектору, продолжаем
            }
        }

        if (!found) {
            throw new NoSuchElementException("Не удалось найти сервис с названием: " + serviceName);
        }
    }
}