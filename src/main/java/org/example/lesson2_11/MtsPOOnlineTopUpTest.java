package org.example.lesson2_11;

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

import static org.junit.Assert.*;


public class MtsPOOnlineTopUpTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
    private WebDriverWait wait;
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
    public void checkUnfilledFieldsForAllOptions() {
        String[] options = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        By wrapper = By.cssSelector("div.select__wrapper");
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
        System.out.println("Телефон: " + phoneText);

        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]")));

    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}