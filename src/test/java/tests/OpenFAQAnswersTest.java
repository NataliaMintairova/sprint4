package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.CookiePage;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static pageobject.MainPage.*;


@RunWith(Parameterized.class)
public class OpenFAQAnswersTest {

    private WebDriver driver;

    private final String questionFAQ;
    private final String answerFAQ;
    private final boolean isVisible;

    public OpenFAQAnswersTest(String questionFAQ, String answerFAQ, boolean isVisible) {
        this.questionFAQ = questionFAQ;
        this.answerFAQ = answerFAQ;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters

    public static Object[][] checkFAQAnswerText() {
        return new Object[][]{
                {QUESTION_HOW_MUCH_COSTS, ANSWER_HOW_MUCH_COSTS, true},
                {QUESTION_WANT_SOME_SCOOTERS, ANSWER_WANT_SOME_SCOOTERS, true},
                {QUESTION_CALC_RENT_TIME, ANSWER_CALC_RENT_TIME, true},
                {QUESTION_ORDER_TODAY, ANSWER_ORDER_TODAY, true},
                {QUESTION_EXTEND_RETURN_EARLIER, ANSWER_EXTEND_RETURN_EARLIER, true},
                {QUESTION_CHARGING_TOGETHER, ANSWER_CHARGING_TOGETHER, true},
                {QUESTION_CANCEL_ORDER, ANSWER_CANCEL_ORDER, true},
                {QUESTION_DELIVER_OUTSIDE_MRR, ANSWER_DELIVER_OUTSIDE_MRR, true},

        };
    }


    @Before

    public void closeCookie() {
        initChrome();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookiePage objCookiePage = new CookiePage(driver);
        objCookiePage.clickCookieButton();
    }



    @Test


    public void isAnswerOpened() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollToElement(questionFAQ);
        objMainPage.isEnabledQuestionButton(questionFAQ);
        objMainPage.clickFAQQuestionButton(questionFAQ);
        boolean isVisibleAnswer = objMainPage.checkVisibleAnswer(answerFAQ);
        Assert.assertTrue(isVisibleAnswer);
        //assertEquals(true, isVisibleAnswer);


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



