package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.CookiePage;
import pageobject.MainPage;
import pageobject.OrderAboutPage;
import pageobject.OrderPage;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class OrderFlowTest {
    private WebDriver driver;
@Test
    public void check1UpperOrderFlow(){
    initFirefox();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://qa-scooter.praktikum-services.ru/");

    CookiePage objCookiePage = new CookiePage(driver);
    objCookiePage.clickCookieButton();

    MainPage objMainPage = new MainPage(driver);
    objMainPage.clickUpperOrderButton();

    OrderPage objOrderPage = new OrderPage(driver);
    objOrderPage.orderFirstWindow("Иван", "Иванов", "Иваново", "123123123123");

    OrderAboutPage objOrdAboutPage = new OrderAboutPage(driver);
    objOrdAboutPage.clickWhenBringButton();
    String deliveryDate = LocalDate.now().plusDays(1).toString();
    objOrdAboutPage.selectDeliveryDate(deliveryDate);
    objOrdAboutPage.clickSelectedDateButton();

    objOrdAboutPage.clickRentalTimeButton();
    objOrdAboutPage.choose3RentalTime();

    objOrdAboutPage.chooseBlackCheckbox();

    objOrdAboutPage.setComment();

    objOrdAboutPage.clickOrderButton();
    objOrdAboutPage.clickYesApplyOrderButton();
    boolean isVisibleOrderedWindow = objOrdAboutPage.isDisplayedWindowOrderApplied();
    Assert.assertTrue(isVisibleOrderedWindow);
}

@Test
public void check2UpperOrderFlow() {
    initChrome();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://qa-scooter.praktikum-services.ru/");

    CookiePage objCookiePage = new CookiePage(driver);
    objCookiePage.clickCookieButton();

    MainPage objMainPage = new MainPage(driver);
    objMainPage.clickUpperOrderButton();

    OrderPage objOrderPage = new OrderPage(driver);
    objOrderPage.orderFirstWindow("Мария", "Марьина", "Марьино", "987654321654");

    OrderAboutPage objOrdAboutPage = new OrderAboutPage(driver);
    objOrdAboutPage.clickWhenBringButton();
    String deliveryDate = LocalDate.now().plusWeeks(1).toString();
    objOrdAboutPage.selectDeliveryDate(deliveryDate);
    objOrdAboutPage.clickSelectedDateButton();

    objOrdAboutPage.clickRentalTimeButton();
    objOrdAboutPage.choose2RentalTime();

    objOrdAboutPage.chooseGreyCheckbox();

    objOrdAboutPage.clickOrderButton();
    objOrdAboutPage.clickYesApplyOrderButton();

    boolean isVisibleOrderedWindow = objOrdAboutPage.isDisplayedWindowOrderApplied();
    Assert.assertTrue(isVisibleOrderedWindow);
}


@Test
public void checkLowerOrderFlow() {
    initFirefox();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://qa-scooter.praktikum-services.ru/");

    CookiePage objCookiePage = new CookiePage(driver);
    objCookiePage.clickCookieButton();

    MainPage objMainPage = new MainPage(driver);
    objMainPage.scrollToLowerOrderButton();
    objMainPage.clickLowerOrderButton();

}

    @After
    public void tearDown() {
        driver.quit();
    }


    public void initChrome(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public void initFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "/home/tasha/Рабочий стол/я.практикум/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver(options);
    }

}
