package org.example.lesson2_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.ObservableInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
@Epic("Пополнение MTS онлайн")
@Feature("UI тесты страницы пополнения")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MtsPOOnlineTopUpTest {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
    private WebDriverWait wait;
    private ObservableInputStream.Observer logger;
    private Object target;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        wait = new WebDriverWait(driver, 3);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
        mainPage.scrollToPaymentSection();
        paymentPage = new PaymentPage(driver);

    }
    @Test
    @Story("Блок 'Онлайн пополнение\\n" +
            "            \"без комиссии'")
    @DisplayName("Проверка надписей в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность")
    public void checkUnfilledFieldsForAllOptions() {
        String[] options = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String option : options) {
            mainPage.selectService(option);
            switch (option) {
                case "Услуги связи":
                    assertEquals("Номер телефона", paymentPage.getFieldPlaceholder(By.cssSelector("#pay-section #connection-phone")));
                    assertEquals("Сумма", paymentPage.getFieldPlaceholder(By.cssSelector("#connection-sum")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#connection-email")));
                    break;
                case "Домашний интернет":
                    assertEquals("Номер абонента", paymentPage.getFieldPlaceholder(By.cssSelector("#internet-phone")));
                    assertEquals("Сумма", paymentPage.getFieldPlaceholder(By.cssSelector("#connection-sum")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#internet-email")));
                    break;
                case "Рассрочка":
                    assertEquals("Номер счета на 44", paymentPage.getFieldPlaceholder(By.cssSelector("#score-instalment")));
                    assertEquals("Сумма", paymentPage.getFieldPlaceholder(By.cssSelector("#instalment-sum")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#instalment-email")));
                    break;
                case "Задолженность":
                    assertEquals("Номер счета на 2073", paymentPage.getFieldPlaceholder(By.cssSelector("#score-arrears")));
                    assertEquals("Сумма", paymentPage.getFieldPlaceholder(By.cssSelector("#arrears-sum")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#arrears-email")));
                    break;
            }
        }
    }
    @Test
    @Story("Форма пополнения 'Услуги связи'")
    @DisplayName("Заполнение формы услуги связи, проверка суммы, номера телефона и наличия иконок платежных систем в окне подтверждения")
    public void testServicesConnectionOption() throws InterruptedException {
        mainPage.selectService("Услуги связи");

        paymentPage.fillField(By.xpath("//*[@id=\"connection-phone\"]"), "297777777");
        paymentPage.fillField(By.xpath("//*[@id=\"connection-sum\"]"), "50");
        paymentPage.fillField(By.xpath("//*[@id=\"connection-email\"]"), "test@example.com");
        paymentPage.clickContinue();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));

        String sumText = paymentPage.getSumInConfirmation();
        String phoneText = paymentPage.getPhoneNumberInConfirmation();

        assertNotNull(sumText);
        assertNotNull(phoneText);

        System.out.println("Сумма: " + sumText);
        System.out.println("Телефон: " + phoneText.replaceAll(".*Номер:\\s*", ""));

        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]")));

    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            ScreenshotMaker.makeScreenshot(driver, "pay_page.png");
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
    public static class AllureUtils {
        @Attachment(value = "Screenshot", type = "image/png")
        public static byte[] makeScreenshot(WebDriver driver) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    }
    public static class ScreenshotMaker {
        public static void makeScreenshot (WebDriver driver, String fileName) {
            File temp = ((TakesScreenshot)
                    driver).getScreenshotAs (OutputType.FILE);
            File destination = new File("./target/" + "pay_page.png");
            try {
                FileUtils.copyFile(temp, destination);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        String fileName = "failure-" + System.currentTimeMillis() + ".png";
        try {
            ScreenshotMaker.makeScreenshot(driver, fileName);
            logger.error("onException: Screenshot saved in target/" + fileName);
        } catch (Exception e) {
            logger.error("Failed to take screenshot during exception handling", e);
        }
    }
}