package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.CookiePage;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static pageobject.MainPage.*;


@RunWith(Parameterized.class)
public class OpenFAQAnswersTest extends BaseClassTest {

    private final String questionFAQ;
    private final String answerFAQ;

    public OpenFAQAnswersTest(String questionFAQ, String answerFAQ) {
        this.questionFAQ = questionFAQ;
        this.answerFAQ = answerFAQ;
    }

    @Parameterized.Parameters

    public static Object[][] checkFAQAnswerTest() {
        return new Object[][]{
                {QUESTION_HOW_MUCH_COSTS, ANSWER_HOW_MUCH_COSTS},
                {QUESTION_WANT_SOME_SCOOTERS, ANSWER_WANT_SOME_SCOOTERS},
                {QUESTION_CALC_RENT_TIME, ANSWER_CALC_RENT_TIME},
                {QUESTION_ORDER_TODAY, ANSWER_ORDER_TODAY},
                {QUESTION_EXTEND_RETURN_EARLIER, ANSWER_EXTEND_RETURN_EARLIER},
                {QUESTION_CHARGING_TOGETHER, ANSWER_CHARGING_TOGETHER},
                {QUESTION_CANCEL_ORDER, ANSWER_CANCEL_ORDER},
                {QUESTION_DELIVER_OUTSIDE_MRR, ANSWER_DELIVER_OUTSIDE_MRR},

        };
    }


    @Test

    public void isAnswerOpenedTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollToElement(questionFAQ);
        objMainPage.isEnabledQuestionButton(questionFAQ);
        objMainPage.clickFAQQuestionButton(questionFAQ);
        objMainPage.isAnswerVisible();
        String actAnswersText = objMainPage.getAnswersText();
        String expAnswerText = answerFAQ;
        assertEquals("Текст ответа не совпадает с ожидаемым", expAnswerText, actAnswersText);
    }
}



