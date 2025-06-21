package org.example.lesson2_9;

import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class MtsOnlineTopUpTest {
    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement acceptCookiesButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]"))
        );
        acceptCookiesButton.click();

        Thread.sleep(1000);
        WebElement targetElement = wait.until(
               ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"))
        );
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);

    }

    @Test
    public void testOnlineTopUpBlock() throws InterruptedException {
        WebElement blockTitle = driver.findElement(By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2"));
        assertNotNull("Блок с названием 'Онлайн пополнение без комиссии' не найден", blockTitle);
        assertTrue("Название блока некорректное", blockTitle.isDisplayed());

        List<WebElement> paymentLogos = driver.findElements(By.cssSelector("img[alt='MasterCard']"));
        assertFalse("Логотипы платёжных систем не найдены", paymentLogos.isEmpty());
        for (WebElement logo : paymentLogos) {
            assertTrue("Логотип не отображается", logo.isDisplayed());
        }

        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.sendKeys("297777777");
        Thread.sleep(1000);

        WebElement amountInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        amountInput.sendKeys("50");
        Thread.sleep(1000);

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection > button"));

        assertTrue("Кнопка 'Продолжить' недоступна", continueButton.isEnabled());

        continueButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
