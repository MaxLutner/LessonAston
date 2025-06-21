package org.example.lesson2_10;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.*;


public class MtsPOOnlineTopUpTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;
    private WebDriverWait wait;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        mainPage = new MainPage(driver);
        mainPage.acceptCookies();
        mainPage.scrollToPaymentSection();
        paymentPage = new PaymentPage(driver);

        String selectedService = mainPage.getSelectedService();
        assertEquals("Услуги связи", selectedService.toLowerCase());
        checkUnfilledFieldsForAllOptions();
        testServicesConnectionOption();
    }

    private void checkUnfilledFieldsForAllOptions() {
        String[] options = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String option : options) {
            mainPage.selectService(option);
            switch (option.toLowerCase()) {
                case "Услуги связи":
                    assertEquals("Номер телефона", paymentPage.getFieldPlaceholder(By.cssSelector("#pay-section #connection-phone")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#connection-email")));
                    break;
                case "Домашний интернет":
                    assertEquals("Номер телефона", paymentPage.getFieldPlaceholder(By.cssSelector("#internet-phone")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#internet-email")));
                    break;
                case "Рассрочка":
                    assertEquals("Номер счета", paymentPage.getFieldPlaceholder(By.cssSelector("#score-instalment")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#instalment-email")));
                    break;
                case "Задолженность":
                    assertEquals("Номер счета", paymentPage.getFieldPlaceholder(By.cssSelector("#score-arrears")));
                    assertEquals("E-mail для отправки чека", paymentPage.getFieldPlaceholder(By.cssSelector("#arrears-email")));
                    break;
            }
        }
    }

    private void testServicesConnectionOption() throws InterruptedException {
        mainPage.selectService("Услуги связи");

        paymentPage.fillField(By.xpath("//*[@id=\"connection-phone\"]"), "297777777");
        paymentPage.fillField(By.xpath("#connection-email"), "test@example.com");

        paymentPage.clickContinue();

        ConfirmationDialog confirmDialog = new ConfirmationDialog(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div")));
        assertTrue(confirmDialog.isDisplayed());

        String sumText = paymentPage.getSumInConfirmation();
        String phoneText = paymentPage.getPhoneNumberInConfirmation();

        assertNotNull(sumText);
        assertNotNull(phoneText);

        System.out.println("Сумма: " + sumText);
        System.out.println("Телефон: " + phoneText);

        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("//div[contains(@class,'icons-container')]//img[1]")));
        assertTrue(paymentPage.isPaymentIconPresent(By.xpath("//div[contains(@class,'icons-container')]//img[2]")));

    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}