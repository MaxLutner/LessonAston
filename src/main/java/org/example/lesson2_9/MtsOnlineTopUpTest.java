package org.example.lesson2_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class MtsOnlineTopUpTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
    }

    @Test
    public void testOnlineTopUpBlock() throws InterruptedException {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение /n без комиссии')]"));
        assertNotNull("Блок с названием 'Онлайн пополнение без комиссии' не найден", blockTitle);
        assertTrue("Название блока некорректное", blockTitle.isDisplayed());

        List<WebElement> paymentLogos = driver.findElements(By.cssSelector("img[alt='MasterCard']"));
        assertFalse("Логотипы платёжных систем не найдены", paymentLogos.isEmpty());
        for (WebElement logo : paymentLogos) {
            assertTrue("Логотип не отображается", logo.isDisplayed());
        }

        WebElement moreLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertNotNull("Ссылка 'Подробнее о сервисе' не найдена", moreLink);
        String originalTab = driver.getWindowHandle();

        moreLink.click();

        Thread.sleep(2000);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String newUrl = driver.getCurrentUrl();
        assertTrue("Страница по ссылке 'Подробнее о сервисе' не открылась", newUrl.contains("mts.by"));

        driver.close();
        driver.switchTo().window(originalTab);

        WebElement serviceDropdownButton = driver.findElement(By.xpath("//button[.//span[contains(text(), 'Услуги связи')]]"));
        serviceDropdownButton.click();

        WebElement serviceOption = driver.findElement(By.xpath("//*[@id='pay-section']//ul/li[1]/p"));
        serviceOption.click();

        WebElement phoneInput = driver.findElement(By.id("id=\"connection-phone\""));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.id("id=\"connection-sum\""));
        amountInput.sendKeys("500");

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='pay-connection']//button"));

        assertTrue("Кнопка 'Продолжить' недоступна", continueButton.isEnabled());

        continueButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
