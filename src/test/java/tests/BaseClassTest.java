package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.CookiePage;

import java.util.concurrent.TimeUnit;

import static pageobject.MainPage.URL_MAIN_PAGE;

public class BaseClassTest {

    protected WebDriver driver;

    @Before

    public void closeCookie() {
        initFirefox();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL_MAIN_PAGE);
        driver.manage().window().maximize();

        CookiePage objCookiePage = new CookiePage(driver);
        objCookiePage.clickCookieButton();
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
