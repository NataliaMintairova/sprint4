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

public class OrderFlowTest extends BaseClassTest {


@Test
    public void check1UpperOrderFlowTest(){

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
public void check2UpperOrderFlowTest() {

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

    Assert.assertTrue(objOrdAboutPage.isDisplayedWindowOrderApplied());
}


@Test
public void checkLowerOrderFlowTest() {

    MainPage objMainPage = new MainPage(driver);
    objMainPage.scrollToLowerOrderButton();
    objMainPage.clickLowerOrderButton();

    OrderPage objOrderPage = new OrderPage(driver);
    Assert.assertTrue(objOrderPage.checkLoadingOrderPage());
}
}
